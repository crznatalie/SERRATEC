package br.com.api.exercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.exercicio.domain.Estoque;
import br.com.api.exercicio.services.EstoqueService;


@RestController
@RequestMapping ("/estoque")

public class EstoqueController {
	
	@Autowired
	EstoqueService estoqueService;
	
	
	//http://localhost:8080/estoque
	//listar todos os produtos
	@GetMapping
	public List<Estoque> listar() {
		return estoqueService.bancoProdutos();
	}
	
	//Mostrar produto específico a partir de número de referência
	@GetMapping ("/{ref}")
	public Estoque buscarProduto(@PathVariable Long ref) {
		return estoqueService.buscarProduto(ref);
	}
	
	//Cadastrar novo produto
	@PostMapping
	public Estoque cadastrarProduto(@RequestBody Estoque estoque) {
		return estoqueService.cadastrarProduto(estoque);
	}
	
	//atualizar informações do produto
	@PutMapping ("/{ref}")
	public Estoque atualizarProduto(@RequestBody Estoque estoque, @PathVariable Long ref) {
		return estoqueService.atualizarProduto(estoque, ref);
	}
	
	//deletar produto
	@DeleteMapping("/{ref}")
	public void deletarProduto(@PathVariable Long ref) {
		estoqueService.deletarProduto(ref);
	}
	
}


