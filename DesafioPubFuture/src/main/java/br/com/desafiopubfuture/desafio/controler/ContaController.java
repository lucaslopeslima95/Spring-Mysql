package br.com.desafiopubfuture.desafio.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.desafiopubfuture.desafio.model.Conta;
import br.com.desafiopubfuture.desafio.repository.ContaRepository;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping("/listartodos")
	public List<Conta> listar() {
		return contaRepository.findAll();
	}
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Conta adicionar(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}
	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletar(@RequestParam int id) {
		contaRepository.deleteById(id);
		return new ResponseEntity<String>("Conta Deletada Com Sucesso",HttpStatus.OK);
	}
	@PutMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<Conta> atualizar(@RequestBody Conta conta) {
		contaRepository.saveAndFlush(conta);
		return new ResponseEntity<Conta>(conta,HttpStatus.OK);
	}
	@GetMapping("/buscaporid")
	@ResponseBody
	public ResponseEntity<Conta> buscarContaId(@RequestParam(name="id") int id) {
		Conta conta = contaRepository.findById(id).get();
		return new ResponseEntity<Conta>(conta,HttpStatus.OK);
	}
	
	public String transfereSaldo(@RequestParam int id1,int id2,double valorTransferido) {
		Conta conta1 = contaRepository.findById(id1).get();
		Conta conta2 = contaRepository.findById(id2).get();
		double saldoConta1 = conta1.getSaldo();
		double saldoConta2 = conta2.getSaldo();
		saldoConta1 = saldoConta1-valorTransferido;
		saldoConta2 = saldoConta2 + valorTransferido;
		
		
		return null;
	}
	
}
