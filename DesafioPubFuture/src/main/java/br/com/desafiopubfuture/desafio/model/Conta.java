package br.com.desafiopubfuture.desafio.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int agencia;
	private String instituicaoFinanceira;
	private int numeroConta;
	private double saldo;
	private String  tipoConta;
}
