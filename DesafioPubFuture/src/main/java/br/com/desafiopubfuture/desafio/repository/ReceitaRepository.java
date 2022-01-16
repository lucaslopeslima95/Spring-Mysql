package br.com.desafiopubfuture.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiopubfuture.desafio.model.FiltroData;
import br.com.desafiopubfuture.desafio.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita,Integer> {

}
