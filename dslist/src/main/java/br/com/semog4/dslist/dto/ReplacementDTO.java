package br.com.semog4.dslist.dto;

/**
 * Esta classe representa o corpo enviado na requisição da url
 * Os parametros enviados no corpo tem que ter o mesmo nome
 * dos atributos da classe
 */

public class ReplacementDTO {

	private Integer sourceIndex;
	private Integer destinationIndex;
	
	
	public Integer getSourceIndex() {
		return sourceIndex;
	}
	
	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
	
	public Integer getDestinationIndex() {
		return destinationIndex;
	}
	
	public void setDestinationIndex(Integer destinationIndex) {
		this.destinationIndex = destinationIndex;
	}
	
	
	
}
