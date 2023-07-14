package br.com.semog4.dslist.dto;

import org.springframework.beans.BeanUtils;

import br.com.semog4.dslist.entities.Game;

public class GameDTO {

	private Long id;
	private String title;
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	private String shortDescription;    
	private String longDescription;
	
	public GameDTO() {
		
	}
	
	
	/*
	 * BeanUtils.copyProperties copia/atribui todos os valores das propriedades da classe Game
	 * para a classe GameDTO, evitando assim ter que ficar fazendo o de x para de cada propriedade.
	 * 
	 * obs.: O uso do copyProperties faz com que tenhamos que criar também os set´s e não somente os
	 * get´s.
	 */

	public GameDTO( Game entityGame ) {
		//this.id = entityGame.getId();
		//this.title = entityGame.getTitle();
		
		//Como são muitos campos, ao invés de continuar atribuindo as propriedades como acima, vamos
		//fazer uso do copyProperties. Isso só funciona se os nomes e tipos das duas classes forem identicas.
		BeanUtils.copyProperties(entityGame, this);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getPlatforms() {
		return platforms;
	}


	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}


	public Double getScore() {
		return score;
	}


	public void setScore(Double score) {
		this.score = score;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getLongDescription() {
		return longDescription;
	}


	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	
	
}
