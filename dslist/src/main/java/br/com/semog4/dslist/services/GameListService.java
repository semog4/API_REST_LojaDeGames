package br.com.semog4.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.semog4.dslist.dto.GameListDTO;
import br.com.semog4.dslist.entities.GameList;
import br.com.semog4.dslist.projections.GameMinProjection;
import br.com.semog4.dslist.repositories.GameListRepository;
import br.com.semog4.dslist.repositories.GameRepository;

@Service
public class GameListService {

	/*
	 * - É invocado pelo Controller
	 * - Acessa o Repository para buscar dados
	 * - Acopla os dados tratados no DTO
	 * - Retorna o DTO para o Controller 
	 */
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	

	//busca todas as listas dos games ( Categoria dos jogos ) 
	//anotação garante que vai ocorrer a transação com o banco e que é somente de leitura
	//isso torna o acesso mais rápido. Garantir que a transação não vai bloquear o banco
	//para realização da operação porque não é de escrita somente de leitura.
	@Transactional(readOnly = true)	
	public List<GameListDTO> findAll(){
		List<GameList> listaCategoriaJogos = gameListRepository.findAll();
		List<GameListDTO> dto = listaCategoriaJogos.stream().map(game -> new GameListDTO(game)).toList(); 
		return dto;
	}
	
	
	//mudar de posição um jogo na lista
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		//retorna todos os games da lista, de uma categoria ( aventura, plataforma .. )
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		//pega o objeto da lista que será retirado e atribui a obj e a list fica com todos os demais elementos sem o elemento removido
		GameMinProjection obj = list.remove(sourceIndex);
		
		//o game retirado da lista acima, é adicionado na lista na posição desejada 
		list.add(destinationIndex, obj);
		
		//identificar somente os elementos que fazem parte da alteração de posições.
		//não é necessário dar update em todas as posições da lista, somente no intervalo.
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int pos = min; pos <= max; pos++) {
			gameListRepository.updateBelongingPosition(listId, list.get(pos).getId(), pos);
		}
				
	}
	
}
