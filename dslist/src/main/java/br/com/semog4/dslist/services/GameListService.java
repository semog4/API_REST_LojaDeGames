package br.com.semog4.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.semog4.dslist.dto.GameListDTO;
import br.com.semog4.dslist.dto.GameMinDTO;
import br.com.semog4.dslist.entities.GameList;
import br.com.semog4.dslist.repositories.GameListRepository;

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
	
	
}
