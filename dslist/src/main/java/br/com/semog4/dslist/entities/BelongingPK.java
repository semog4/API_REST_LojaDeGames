package br.com.semog4.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Indica que esta classe está encapsulando duas chaves estrangeiras,
//e que a mesma será utilizada por um atributo em outra classe.
//
@Embeddable
public class BelongingPK {
 
	@ManyToOne
	@JoinColumn( name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn( name = "list_id")
	private GameList gameListId;
	

	public BelongingPK() {
		
	}
		
	public BelongingPK(Game game, GameList gameListId) {
		this.game = game;
		this.gameListId = gameListId;
	}

	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public GameList getGameListId() {
		return gameListId;
	}


	public void setGameListId(GameList gameListId) {
		this.gameListId = gameListId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(game, gameListId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(gameListId, other.gameListId);
	}
	
}
