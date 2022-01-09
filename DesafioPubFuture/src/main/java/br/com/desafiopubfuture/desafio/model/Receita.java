package br.com.desafiopubfuture.desafio.model;

import java.sql.Date;

import javax.persistence.Entity;

import lombok.Data;


@Entity
public class Receita {
	
	private Long id;
	private double valor;
	private Date dataRecebimento;
	private Date dataRecebimentoEsperado;
	private String descricao;
	private int conta;
	private String tipoReceita;
	
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
	public Date getDataRecebimento() {
		return dataRecebimento;
	}
	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	public Date getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}
	public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public String getTipoReceita() {
		return tipoReceita;
	}
	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	} 
	
}
