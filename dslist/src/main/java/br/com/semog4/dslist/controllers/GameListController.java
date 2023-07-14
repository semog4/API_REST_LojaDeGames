package br.com.semog4.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.semog4.dslist.dto.GameListDTO;
import br.com.semog4.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")  // recurso listas ( categoria dos jogos )
public class GameListController {

	@Autowired
	private GameListService gameListService;
		
	//criando os endpoints para as lista ( categoria dos jogos )
	
	@GetMapping
	public List<GameListDTO> findAll(){
		
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
}
