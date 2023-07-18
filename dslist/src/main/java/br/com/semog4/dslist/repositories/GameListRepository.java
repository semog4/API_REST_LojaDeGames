package br.com.semog4.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.semog4.dslist.entities.GameList;

//Funções do repositório no sistema:
//Repositório para acessar a lista de categoria de jogos
//Repositório para alterar a posição do game na lista
public interface GameListRepository extends JpaRepository<GameList , Long>{

	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
	
}
