package br.com.api.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.exercicio.domain.Player;

@Repository("player")
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	
}
