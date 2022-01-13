package br.com.desafiopubfuture.desafio.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numeroConta;
	private int agencia;
	private double saldo;
	private String  tipoConta;
	private String instituicaoFinanceira;
	
	
}
