package br.com.semog4.dslist.dto;

import br.com.semog4.dslist.entities.Game;

public class GameMinDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;    

	public GameMinDTO() {
		
	}
	
	public GameMinDTO(Game entityGame) {
		id = entityGame.getId();
		title = entityGame.getTitle();
		year = entityGame.getYear();
		imgUrl = entityGame.getImgUrl();
		shortDescription = entityGame.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	
	public String getTitle() {
		return title;
	}

	
	public Integer getYear() {
		return year;
	}

	
	public String getImgUrl() {
		return imgUrl;
	}

	
	public String getShortDescription() {
		return shortDescription;
	}

	
}
