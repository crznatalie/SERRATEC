package br.com.api.calculadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.calculadora.domain.Operacao;
import br.com.api.calculadora.service.CalculadoraService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/calc")
public class CalculadoraController {

	@Autowired
	CalculadoraService calculadoraService;
	
	
	@GetMapping("/listar")
	public List<Operacao> list() {
		return calculadoraService.operacao();
	}
	
	//consultar operações por id
	@GetMapping("/{id}")
	public ResponseEntity<Operacao> buscarOperacao(@PathVariable Long id) {
		return calculadoraService.buscarOperacao(id);
	}
	
	//fazer operações com request body
	@PostMapping("/soma")
	@ResponseStatus
	public Operacao novaSoma(@Valid @RequestBody Operacao operacao) {
		return calculadoraService.soma(operacao);
	}
	@PostMapping("/sub")
	@ResponseStatus
	public Operacao novaSub(@Valid @RequestBody Operacao operacao) {
		return calculadoraService.subtracao(operacao);
	}
	@PostMapping("/mult")
	@ResponseStatus
	public Operacao novaMult(@Valid @RequestBody Operacao operacao) {
		return calculadoraService.multiplicacao(operacao);
	}
	@PostMapping("/div")
	@ResponseStatus
	public Operacao novaDiv(@Valid @RequestBody Operacao operacao) {
		return calculadoraService.divisao(operacao);
	}
	
//	@PostMapping("/soma/{num1}/{num2}/")
//	@ResponseStatus
//	public Operacao novaSoma(@Valid @PathVariable Double num1, @PathVariable Double num2) {
//		return calculadoraService.soma(num1,num2);
//	}
//	
//	@PostMapping("/sub/{num1}/{num2}/")
//	@ResponseStatus
//	public Operacao novaSubtracao(@Valid @PathVariable Double num1, @PathVariable Double num2) {
//		return calculadoraService.subtracao(num1,num2);
//	}
//	
//	@PostMapping("/mult/{num1}/{num2}/")
//	@ResponseStatus
//	public Operacao novaMultiplicacao(@Valid @PathVariable Double num1, @PathVariable Double num2) {
//		return calculadoraService.multiplicacao(num1,num2);
//	}
//	
//	@PostMapping("/div/{num1}/{num2}/")
//	@ResponseStatus
//	public Operacao novaDivisao(@Valid @PathVariable Double num1, @PathVariable Double num2) {
//		return calculadoraService.divisao(num1,num2);
//	}
	
	
//	@PostMapping("/soma")
//	@ResponseStatus
//	public Operacao novaSoma(@Valid @RequestParam(required=false) Double num1, @RequestParam(required=false) Double num2) {
//		return calculadoraService.soma(num1,num2);
//	}
//	
//	@PostMapping("/sub")
//	@ResponseStatus
//	public Operacao novaSubtracao(@Valid @RequestParam(required=false) Double num1, @RequestParam(required=false) Double num2) {
//		return calculadoraService.subtracao(num1,num2);
//	}
//	
//	@PostMapping("/mult")
//	@ResponseStatus
//	public Operacao novaMultiplicacao(@Valid @RequestParam(required=false) Double num1, @RequestParam(required=false) Double num2) {
//		return calculadoraService.multiplicacao(num1,num2);
//	}
//	
//	@PostMapping("/div")
//	@ResponseStatus
//	public Operacao novaDivisao(@Valid @RequestParam(required=false) Double num1, @RequestParam(required=false) Double num2) {
//		return calculadoraService.divisao(num1,num2);
//	}
	
}
