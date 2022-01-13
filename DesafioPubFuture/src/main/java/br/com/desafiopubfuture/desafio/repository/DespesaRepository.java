package br.com.desafiopubfuture.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafiopubfuture.desafio.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

}
