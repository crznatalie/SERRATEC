package br.com.api.calculadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.calculadora.domain.Operacao;

@Repository("calculadora")
public interface CalculadoraRepository extends JpaRepository<Operacao, Long> {

}
