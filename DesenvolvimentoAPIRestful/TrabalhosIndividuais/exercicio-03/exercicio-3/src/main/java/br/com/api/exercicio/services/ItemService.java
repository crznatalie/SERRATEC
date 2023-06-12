package br.com.api.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import br.com.api.exercicio.domain.Item;
import br.com.api.exercicio.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> item() {
		return itemRepository.findAll();
	}

	public ResponseEntity<Item> findItem(Integer id) {
		Optional<Item> item = itemRepository.findById(id);
		if (item.isPresent()) {
			return ResponseEntity.ok(item.get());
		}
		return ResponseEntity.notFound().build();
	}

	public Item newItem(Item item) {
		return itemRepository.save(item);
	}

	public ResponseEntity<Void> delete(Integer id) {
		if (!itemRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		itemRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public void favorite(Integer id) {
		Optional <Item> itemOptional = itemRepository.findById(id);
		Item unfavoriteItem = itemOptional.get();
		if (!unfavoriteItem.isFavorite()) {
			unfavoriteItem.setFavorite(true);
			itemRepository.save(unfavoriteItem);
		}
	}
	
	public void unfavorite(Integer id) {
			Optional <Item> playerOptional = itemRepository.findById(id);
			Item favoriteItem = playerOptional.get();
			if (favoriteItem.isFavorite()) {
				favoriteItem.setFavorite(false);
				itemRepository.save(favoriteItem);
			}
	}
	
	public ResponseEntity<Item> updateItem(Item item, Integer id) {
		Optional<Item> itemOptional = itemRepository.findById(id);
		Item updatedItem = itemOptional.get();
		updatedItem.setItem(item.getItem());
		updatedItem.setType(item.getType());
		updatedItem.setMaterial(item.getMaterial());
		updatedItem.setColor(item.getColor());
		updatedItem.setBrand(item.getBrand());
		item = itemRepository.save(updatedItem);
		return ResponseEntity.ok(item);
	}

	
//	
//	public void death(Integer killedId, Integer killerId) {
//		Optional <Player> killedOptional = playerRepository.findById(killedId);
//		Optional <Player> killerOptional = playerRepository.findById(killerId);
//		Player killed = killedOptional.get();
//		Player killer = killerOptional.get();
//		if (killed.isAlive()) {
//			killed.setDeaths(killed.getDeaths()+1);
//			killer.setKills(killer.getKills()+1);
//			killed.setAlive(false);
//			playerRepository.save(killed);
//			playerRepository.save(killer);
//		}
//	}
//	
//	}
}
