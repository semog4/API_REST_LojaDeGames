package br.com.semog4.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.semog4.dslist.dto.GameDTO;
import br.com.semog4.dslist.dto.GameMinDTO;
import br.com.semog4.dslist.entities.Game;
import br.com.semog4.dslist.repositories.GameRepository;

@Service
public class GameService {

	/*
	 * - É invocado pelo Controller
	 * - Acessa o Repository para buscar dados
	 * - Acopla os dados tratados no DTO
	 * - Retorna o DTO para o Controller 
	 */
	
	@Autowired
	private GameRepository gameRepository;
	

	//busca todos os game min	
	//anotação garante que vai ocorrer a transação com o banco e que é somente de leitura
	//isso torna o acesso mais rápido. Garantir que a transação não vai bloquear o banco
	//para realização da operação porque não é de escrita somente de leitura.
	@Transactional(readOnly = true)	
	public List<GameMinDTO> findAll(){
		List<Game> listaDosGamesComTodosCampos = gameRepository.findAll();
		List<GameMinDTO> dto = listaDosGamesComTodosCampos.stream().map(game -> new GameMinDTO(game)).toList(); 
		return dto;
	}
	
	//busca um game por id
	//anotação garante que vai ocorrer a transação com o banco e que é somente de leitura
	//isso torna o acesso mais rápido. Garantir que a transação não vai bloquear o banco
	//para realização da operação porque não é de escrita somente de leitura.
	@Transactional(readOnly = true)	
	public GameDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(game);
		return dto;
	}
	
	
}
