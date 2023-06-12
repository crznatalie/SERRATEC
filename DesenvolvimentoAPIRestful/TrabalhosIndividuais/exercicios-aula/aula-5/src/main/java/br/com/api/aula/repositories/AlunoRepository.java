package br.com.api.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api.aula.domain.Aluno;


@Repository("aluno") //dar um nome para corrigir o warning ;)
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	
}
