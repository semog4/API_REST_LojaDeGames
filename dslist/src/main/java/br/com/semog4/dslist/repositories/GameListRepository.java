package br.com.semog4.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.semog4.dslist.entities.GameList;

//Repositório para acessar a lista de categoria de jogos
public interface GameListRepository extends JpaRepository<GameList , Long>{

}
