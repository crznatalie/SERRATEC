package br.com.api.aula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.aula.domain.Aluno;
import br.com.api.aula.services.AlunoService;
import br.com.api.aula.services.EmailService;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping ("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	EmailService emailService;
	
	
	//http://localhost:8000/alunos/listar
	@GetMapping("/listar")
	public List<Aluno> listar() {
		return alunoService.findAll();
	}

	//http://localhost:8080/alunos/001
	@GetMapping("/{matricula}")
	public Aluno buscarAluno(@PathVariable Long matricula) {
		return alunoService.buscarAluno(matricula);
	}
	
	@GetMapping("/count") 
	public int count() {
		return alunoService.count();
	}
	
	@DeleteMapping("/matricula")
	public void deletarAluno(@PathVariable Long matricula) {
		alunoService.deletarAluno(matricula);
	}
	
	@PostMapping
	public Aluno cadastrarAluno(@RequestParam String email, @RequestBody Aluno aluno) throws MessagingException {
		emailService.envioEmailCadastro(email, aluno);
		return alunoService.cadastrarAluno(aluno);
	}
	
	@PutMapping("/{matricula}") //@PatchMapping
	public Aluno atualizarAluno(@RequestBody Aluno aluno, @PathVariable Long matricula) {
		return alunoService.atualizarAluno(aluno, matricula);
	}
}


  