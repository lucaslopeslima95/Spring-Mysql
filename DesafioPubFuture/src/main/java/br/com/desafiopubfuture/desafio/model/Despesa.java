package br.com.desafiopubfuture.desafio.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Despesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double valor;
	private Date dataPagamento;
	private Date dataPagamentoEsperado;
	private String tipoDespesa;
	private int conta;
	
	
}
