package br.com.api.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.aula.domain.Aluno;
import br.com.api.aula.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
//    private	List<Aluno> lista = new ArrayList<>();
//	 
//	public List<Aluno> bancoAlunos() {
//		if (lista.isEmpty()) {
//			lista.add(new Aluno(2023001L, "Ana", "98844-2211", true));
//			lista.add(new Aluno(2023002L, "Cassio", "98844-2212", true));
//			lista.add(new Aluno(2023003L, "Gabriel", "98844-2213", false));
//		}
//		return lista;
//	}
    
    
    public List<Aluno> findAll() {
    	return alunoRepository.findAll();
    }
	
	public Aluno buscarAluno(Long matricula) {
//		for(int i = 0; i < lista.size(); i++) {
//			if (lista.get(i).getMatricula().equals(matricula)) {
//				return lista.get(i);
//			}
//		}
		return null;
	}
	
	public int count() {
//		return lista.size();
		return 0;
	}
	
	//delete logico
	public void deletarAluno(Long matricula) {
//		lista.remove(buscarAluno(matricula));
		Aluno aluno = buscarAluno(matricula);
		if(aluno.isAtivo());
			aluno.setAtivo(false);
	}

	public Aluno cadastrarAluno(Aluno aluno) {
		if(buscarAluno(aluno.getMatricula()) == null) {
//			lista.add(aluno);
			return alunoRepository.save(aluno);
		}
		return null;
	}
	
	public Aluno atualizarAluno (Aluno alunoAtualizado, Long matricula) {
		Aluno alunoAntigo = buscarAluno(matricula);
		if(buscarAluno(matricula) !=null) {
			 //alterar todos os campos
			alunoAntigo.setMatricula(alunoAtualizado.getMatricula());
			alunoAntigo.setNome(alunoAtualizado.getNome());
			alunoAntigo.setTelefone(alunoAtualizado.getTelefone());
			alunoAntigo.setAtivo(alunoAtualizado.isAtivo());
			//salvar o registro atualizado
			return alunoAntigo;
//			apagar o registro atual e salva um novo
//			Integer idRecuperado = aluno.id;
//			deletarAluno(matricula);
//			cadastrarAluno(aluno);
//			aluno.setId(idRecuperado);
//			return aluno;
		}
		return null;
	}
}
