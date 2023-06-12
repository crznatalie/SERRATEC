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

import br.com.api.exercicio.domain.Player;
import br.com.api.exercicio.services.PlayerService;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/players")
public class PlayerControllers {

	@Autowired
	PlayerService playerService;
	
	//http://localhost:8000/players/list
	@GetMapping("/list")
	public List<Player> list() {
		return playerService.list();
	}
	
	//http://localhost:8000/players/id
	@GetMapping("/{id}")
	public ResponseEntity<Player> findPlayer(@PathVariable Integer id) {
		return playerService.findPlayer(id);
	}
	
	//player saiu da partida
	@DeleteMapping("/{id}")
	public void quit(@PathVariable Integer id) {
		playerService.quit(id);
	}
	
	//player morreu
	@DeleteMapping("/death")
	public void death(@PathParam("killedId") Integer killedId, @PathParam("killerId") Integer killerId) {
		playerService.death(killedId, killerId);
	}
	
	//player reviveu
	@PutMapping ("/revive/{id}")
	public void backToLife(@PathVariable Integer id) {
		playerService.revive(id);
	}
	
	//novo player entrou na partida
	@PostMapping
	@ResponseStatus
	public void join(@RequestBody Player player) {
		playerService.join(player);
	}

	//player mudou de classe
	@PutMapping("/changeclass/{id}")
	public ResponseEntity<Player> changeClass(@RequestBody Player player, @PathVariable Integer id) {
		return playerService.changeClass(player, id); 	
	}
}
