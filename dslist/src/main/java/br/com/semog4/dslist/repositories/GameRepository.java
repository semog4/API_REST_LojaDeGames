package br.com.semog4.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.semog4.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game , Long>{

}
