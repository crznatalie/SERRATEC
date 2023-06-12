package br.com.api.exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.exercicio.domain.Player;
import br.com.api.exercicio.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	public List<Player> list(){
		return playerRepository.findAll();
	}
	
	public ResponseEntity<Player> findPlayer(Integer id){
		Optional<Player> player = playerRepository.findById(id);
		if (player.isPresent()) {
		return ResponseEntity.ok(player.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Void> quit(Integer id) {
		if (!playerRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
		}
		playerRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		}
	

	public Player join(Player player) {
		return playerRepository.save(player);
	}
	
	public ResponseEntity<Player> changeClass(Player player, Integer id) {
		Optional<Player> playerOptional = playerRepository.findById(id);
		Player newClass = playerOptional.get();
		newClass.setPclass(player.getPclass());
		player = playerRepository.save(newClass);
		return ResponseEntity.ok(player);
	}
	
	public void death(Integer killedId, Integer killerId) {
		Optional <Player> killedOptional = playerRepository.findById(killedId);
		Optional <Player> killerOptional = playerRepository.findById(killerId);
		Player killed = killedOptional.get();
		Player killer = killerOptional.get();
		if (killed.isAlive()) {
			killed.setDeaths(killed.getDeaths()+1);
			killer.setKills(killer.getKills()+1);
			killed.setAlive(false);
			playerRepository.save(killed);
			playerRepository.save(killer);
		}
	}
	
	public void revive(Integer id) {
		Optional <Player> playerOptional = playerRepository.findById(id);
		Player deadPlayer = playerOptional.get();
		if (!deadPlayer.isAlive()) {
			deadPlayer.setAlive(true);
			playerRepository.save(deadPlayer);
		}
	}
}
	


