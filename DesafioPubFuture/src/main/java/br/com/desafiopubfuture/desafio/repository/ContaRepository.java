package br.com.desafiopubfuture.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiopubfuture.desafio.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
