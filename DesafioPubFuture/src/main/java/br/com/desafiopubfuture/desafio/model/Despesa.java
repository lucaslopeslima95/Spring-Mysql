package br.com.desafiopubfuture.desafio.model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Despesa {
	
	private Long id;
	private double valor;
	private Date dataPagamento;
	private Date dataPagamentoEsperado;
	private String tipoDespesa;
	private int conta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public Date getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}
	public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}
	public String getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
}
