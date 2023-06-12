package br.com.api.exercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.exercicio.domain.Item;
import br.com.api.exercicio.services.ItemService;


@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	//http://localhost:8000/items/list
	@GetMapping("/list")
	public List<Item> list() {
		return itemService.item();
	}
	
	//http://localhost:8000/items/id
	@GetMapping("/{id}")
	public ResponseEntity<Item> findItem(@PathVariable Integer id) {
		return itemService.findItem(id);
	}
	
	
	//cadastrar item
	@PostMapping
	@ResponseStatus
	public void newItem(@RequestBody Item item) {
		itemService.newItem(item);
	}
	
	//deletar item
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		itemService.delete(id);
	}

	
	//favoritar item
	@PutMapping ("/favorite/{id}")
	public void favorite(@PathVariable Integer id) {
		itemService.favorite(id);
	}
	
	//desfavoritar item
	@PutMapping ("/unfavorite/{id}")
	public void unfavorite(@PathVariable Integer id) {
		itemService.unfavorite(id);
	}

	//editar item
	@PutMapping("/updateitem/{id}")
	public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable Integer id) {
		return itemService.updateItem(item, id); 	
	}
}