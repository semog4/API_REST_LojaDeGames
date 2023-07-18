package br.com.semog4.dslist.dto;

import br.com.semog4.dslist.entities.Game;
import br.com.semog4.dslist.projections.GameMinProjection;

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

	public GameMinDTO(GameMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		year = projection.getGameYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
		
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
