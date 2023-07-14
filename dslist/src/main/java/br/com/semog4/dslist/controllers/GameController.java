package br.com.semog4.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semog4.dslist.dto.GameDTO;
import br.com.semog4.dslist.dto.GameMinDTO;
import br.com.semog4.dslist.services.GameService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/games")  // recurso games
public class GameController {

	@Autowired
	private GameService gameService;
		
	//criando os endpoints para game
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping (value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		   GameDTO dto = gameService.findById(id);
	       return dto;
	}
	
	
}
