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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopubfuture.desafio.model.Despesa;
import br.com.desafiopubfuture.desafio.model.FiltroData;
import br.com.desafiopubfuture.desafio.repository.DespesaRepository;


@RestController
@RequestMapping("/despesa")
public class DespesaController {
	

	@Autowired
	private DespesaRepository despesaRepository;

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Despesa adicionar(@RequestBody Despesa despesa) {
		return despesaRepository.save(despesa);
	}

	@PutMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<Despesa> atualizar(@RequestBody Despesa despesa) {
		despesaRepository.saveAndFlush(despesa);
		return new ResponseEntity<Despesa>(despesa, HttpStatus.OK);
	}

	@GetMapping("/busca_por_id")
	@ResponseBody
	public ResponseEntity<Despesa> buscardespesaId(@RequestParam(name = "id") int id) {
		Despesa despesa = despesaRepository.findById(id).get();
		return new ResponseEntity<Despesa>(despesa, HttpStatus.OK);
	}

	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletar(@RequestParam int id) {
		despesaRepository.deleteById(id);
		return new ResponseEntity<String>("despesa Deletada Com Sucesso", HttpStatus.OK);
	}

	@GetMapping("/filtrar_por_data")
	@ResponseBody
	public ResponseEntity<String> filtrarPorData(@RequestBody FiltroData filtrodata) {
		for (int i = 1; i <= despesaRepository.count(); i++) {
			if (filtrodata.getDataInicial().compareTo(despesaRepository.getById(i).getDataPagamento()) > 0) {
				if (filtrodata.getDataFinal().compareTo(despesaRepository.getById(i).getDataPagamento()) < 0) {
					buscardespesaId(i);
				}
			}
		}
		return new ResponseEntity<String>("Nemhuma despesa Encontrada Nesse Periodo", HttpStatus.OK);
	}

	@GetMapping("/filtrar_por_tipo_despesa")
	@ResponseBody
	public ResponseEntity<String> filtrarPorTipodespesa(@RequestBody String tipodespesaBuscada) {
		for (int i = 1; i < despesaRepository.count(); i++) {
			if (despesaRepository.getById(i).getTipoDespesa().equalsIgnoreCase(tipodespesaBuscada)) {
				buscardespesaId(i);
			}
		}
		return new ResponseEntity<String>("Nemhuma despesa Encontrada Nesse Periodo", HttpStatus.OK);
	}

	@GetMapping("/listar_todos")
	public List<Despesa> listar() {
		return despesaRepository.findAll();
	}

	@GetMapping("/mostra_saldo_total_de_despesa")
	public ResponseEntity<String> mostrasaldototal() {
		double saldoTotal = 0;
		for (int i = 1; i <= despesaRepository.count(); i++) {
			saldoTotal = despesaRepository.getById(i).getValor() + saldoTotal;
		}
		return new ResponseEntity<String>("O Saldo Total de despesas é " + saldoTotal, HttpStatus.OK);
	}


}
