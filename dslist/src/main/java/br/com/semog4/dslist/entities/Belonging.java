package br.com.semog4.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*
 * Esta classe é o espelho da tabela de relacionamento
 * entre as tabelas tb_game e tb_gameList
 */

@Entity
@Table( name="tb_belonging")
public class Belonging {

	/*
	 * Inicialmente pensando teriamos nessa classe a chave id
	 * da Game e da GameList, sendo que não podemos ter duas
	 * chaves para identificar um registro ao utilizar a 
	 * JpaRepository, logo criamos a BelongingPK que irá
	 * gerar um id único para o relacionamento.
	 */
	
	//Indica que o id irá derivar da classe BelongingPK
	@EmbeddedId 
	private BelongingPK id = new BelongingPK();
	private Integer position;
	
	public Belonging() {
		
	}

	public Belonging(Game game, GameList list, Integer position) {
		//passa direto para o BelongingPK os id´s referentes
		id.setGame(game);
		id.setGameListId(list);
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
