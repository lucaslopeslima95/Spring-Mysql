package br.com.desafiopubfuture.desafio.model;

import lombok.Data;

@Data
public class Transferencia {
	int idDaContaOrigem;
	int idDaContaDestino;
	double valorDaTransferencia;
}
