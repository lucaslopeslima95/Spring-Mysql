package br.com.desafiopubfuture.desafio.model;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Conta {
	
	private Long id;
	private double saldo;
	private String  tipoConta;
	private String instituicaoFinanceira;
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(instituicaoFinanceira, saldo, tipoConta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(instituicaoFinanceira, other.instituicaoFinanceira)
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo)
				&& Objects.equals(tipoConta, other.tipoConta);
	}
	

}
