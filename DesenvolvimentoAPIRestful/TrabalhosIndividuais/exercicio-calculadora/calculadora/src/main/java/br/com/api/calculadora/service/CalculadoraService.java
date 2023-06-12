package br.com.api.calculadora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.calculadora.domain.Operacao;
import br.com.api.calculadora.repositories.CalculadoraRepository;

@Service
public class CalculadoraService {
	
	@Autowired
	CalculadoraRepository calculadoraRepository;

	public List<Operacao> operacao() {
		return calculadoraRepository.findAll();
	}

	public ResponseEntity<Operacao> buscarOperacao(Long id) {
		Optional<Operacao> operacao = calculadoraRepository.findById(id);
		if (operacao.isPresent()) {
			return ResponseEntity.ok(operacao.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	public Operacao soma(Operacao operacao) {
		operacao.setResult(operacao.getNum1()+operacao.getNum2());
		operacao.setTipo("Soma");
		return calculadoraRepository.save(operacao);
	}
	
	public Operacao subtracao(Operacao operacao) {
		operacao.setResult(operacao.getNum1()-operacao.getNum2());
		operacao.setTipo("Subtração");
		return calculadoraRepository.save(operacao);
	}
	
	public Operacao multiplicacao(Operacao operacao) {
		operacao.setResult(operacao.getNum1()*operacao.getNum2());
		operacao.setTipo("Multiplicação");
		return calculadoraRepository.save(operacao);
	}
	
	public Operacao divisao(Operacao operacao) {
		operacao.setResult(operacao.getNum1()/operacao.getNum2());
		operacao.setTipo("Divisão");
		return calculadoraRepository.save(operacao);
	}
	
	public Operacao soma(Double num1, Double num2) {
		Operacao operacao = new Operacao();
		operacao.setNum1(num1);
		operacao.setNum2(num2);
		operacao.setResult(operacao.getNum1()+operacao.getNum2());
		operacao.setTipo("Soma");
		return calculadoraRepository.save(operacao);
	}
	
	public Operacao subtracao(Double num1, Double num2) {
		Operacao operacao = new Operacao();
		operacao.setNum1(num1);
		operacao.setNum2(num2);
		operacao.setResult(operacao.getNum1()-operacao.getNum2());
		operacao.setTipo("Subtração");
		return calculadoraRepository.save(operacao);
	}
	
	public Operacao multiplicacao(Double num1, Double num2) {
		Operacao operacao = new Operacao();
		operacao.setNum1(num1);
		operacao.setNum2(num2);
		operacao.setResult(operacao.getNum1()*operacao.getNum2());
		operacao.setTipo("Multiplicação");
		return calculadoraRepository.save(operacao);
	}
	
	public Operacao divisao(Double num1, Double num2) {
		Operacao operacao = new Operacao();
		operacao.setNum1(num1);
		operacao.setNum2(num2);
		operacao.setResult(operacao.getNum1()/operacao.getNum2());
		operacao.setTipo("Divisão");
		return calculadoraRepository.save(operacao);
	}
}
