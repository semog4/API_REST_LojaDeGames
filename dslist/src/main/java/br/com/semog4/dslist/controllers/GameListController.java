package br.com.semog4.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semog4.dslist.dto.GameListDTO;
import br.com.semog4.dslist.dto.GameMinDTO;
import br.com.semog4.dslist.dto.ReplacementDTO;
import br.com.semog4.dslist.services.GameListService;
import br.com.semog4.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")  // recurso listas ( categoria dos jogos )
public class GameListController {

	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	//criando os endpoints para as lista ( categoria dos jogos )
	
	@GetMapping
	public List<GameListDTO> findAll(){
		
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		 List<GameMinDTO> result = gameService.findByList(listId);
		 return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		
		 gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
		 
	}
		
}
