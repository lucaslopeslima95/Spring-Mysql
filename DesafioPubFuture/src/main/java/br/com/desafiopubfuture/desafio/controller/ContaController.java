package br.com.desafiopubfuture.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopubfuture.desafio.model.Conta;
import br.com.desafiopubfuture.desafio.model.Transferencia;
import br.com.desafiopubfuture.desafio.repository.ContaRepository;

@RestController
@RequestMapping(value ="/conta",produces = "application/json", 
method = {RequestMethod.GET, RequestMethod.PUT})
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;

	@PostMapping(value ="/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Conta> adicionar(@RequestBody Conta conta) {
		contaRepository.save(conta);
		return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}

	@PutMapping(value ="/atualizar")
	@ResponseBody
	public ResponseEntity<Conta> atualizar(@RequestBody Conta conta) {
		contaRepository.saveAndFlush(conta);
		return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}

	@GetMapping(value ="/busca_por_id")
	@ResponseBody
	public ResponseEntity<Conta> buscarContaId(@RequestParam(name = "id") int id) {
		Conta conta = contaRepository.findById(id).get();
		return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}

	@DeleteMapping(value ="/deletar")
	public ResponseEntity<String> deletar(@RequestParam int id) {
		contaRepository.deleteById(id);
		return new ResponseEntity<String>("Conta Deletada Com Sucesso", HttpStatus.OK);
	}

	@GetMapping(value ="/listar_todos")
	public List<Conta> listar() {
		return contaRepository.findAll();
	}

	@GetMapping(value ="/mostra_saldo_total")
	public ResponseEntity<String> mostrasaldototal() {
		double saldoTotal = 0;
		for (int i = 1; i <= contaRepository.count(); i++) {
		saldoTotal = contaRepository.getById(i).getSaldo()+saldoTotal;
		}
		 return new ResponseEntity<String>("O Saldo Total é "+saldoTotal,HttpStatus.OK);
	}
	@PostMapping(value ="/transfere_saldo")
	@ResponseBody
	public Transferencia transfereSaldo(@RequestBody Transferencia transferencia) {

		Conta contaOrigem = contaRepository.findById(transferencia.getIdDaContaOrigem()).get();
		Conta contaDestino = contaRepository.findById(transferencia.getIdDaContaDestino()).get();

		contaOrigem.setSaldo(contaOrigem.getSaldo() - transferencia.getValorDaTransferencia());
		contaDestino.setSaldo(contaDestino.getSaldo() + transferencia.getValorDaTransferencia());

		atualizar(contaOrigem);
		atualizar(contaDestino);

		return transferencia;
	}

}
