package br.com.api.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.exercicio.domain.Item;

@Repository("item")
public interface ItemRepository extends JpaRepository<Item, Integer> {

	
}
