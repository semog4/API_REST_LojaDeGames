package br.com.semog4.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<GameMinDTO> findAll(){
		List<Game> listaDosGamesComTodosCampos = gameRepository.findAll();
		List<GameMinDTO> dto = listaDosGamesComTodosCampos.stream().map(game -> new GameMinDTO(game)).toList(); 
		return dto;
	}
	
	
	
}
