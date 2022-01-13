package br.com.desafiopubfuture.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiopubfuture.desafio.model.Receita;

@Repository
public interface ReceitasRepository extends JpaRepository<Receita,Integer>{

}
