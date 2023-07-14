package br.com.semog4.dslist.dto;

import br.com.semog4.dslist.entities.GameList;

//DTO que representa a lista de categoria de jogos.

public class GameListDTO {

	private Long id;
	private String name;
	
	public GameListDTO( GameList entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
		
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
