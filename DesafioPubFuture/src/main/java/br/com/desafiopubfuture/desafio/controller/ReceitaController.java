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

import br.com.desafiopubfuture.desafio.model.FiltroData;
import br.com.desafiopubfuture.desafio.model.Receita;
import br.com.desafiopubfuture.desafio.repository.ReceitaRepository;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;

	@GetMapping("/listar_todos")
	public List<Receita> listar() {
		return receitaRepository.findAll();
	}

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Receita adicionar(@RequestBody Receita Receita) {
		return receitaRepository.save(Receita);
	}

	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletar(@RequestParam int id) {
		receitaRepository.deleteById(id);
		return new ResponseEntity<String>("Receita Deletada Com Sucesso", HttpStatus.OK);
	}

	@PutMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<Receita> atualizar(@RequestBody Receita Receita) {
		receitaRepository.saveAndFlush(Receita);
		return new ResponseEntity<Receita>(Receita, HttpStatus.OK);
	}

	@GetMapping("/busca_por_id")
	@ResponseBody
	public ResponseEntity<Receita> buscarReceitaId(@RequestParam(name = "id") int id) {
		Receita Receita = receitaRepository.findById(id).get();
		return new ResponseEntity<Receita>(Receita, HttpStatus.OK);
	}

	@GetMapping("/filtrar_por_data")
	@ResponseBody
	public ResponseEntity<String> filtrarPorData(@RequestBody FiltroData filtrodata) {
		for (int i = 1; i <= receitaRepository.count(); i++) {
			if (filtrodata.getDataInicial().compareTo(receitaRepository.getById(i).getDataRecebimento()) > 0) {
				if (filtrodata.getDataFinal().compareTo(receitaRepository.getById(i).getDataRecebimento()) < 0) {
					buscarReceitaId(i);
				}
			}
		}
		return new ResponseEntity<String>("Nemhuma Receita Encontrada Nesse Periodo", HttpStatus.OK);
	}

	@GetMapping("/filtrar_por_tipo_receita")
	@ResponseBody
	public ResponseEntity<String> filtrarPorTipoReceita(@RequestBody String tipoReceitaBuscada) {
		for (int i = 1; i < receitaRepository.count(); i++) {
			if (receitaRepository.getById(i).getTipoReceita().equalsIgnoreCase(tipoReceitaBuscada)) {
				buscarReceitaId(i);
			}
		}
		return new ResponseEntity<String>("Nemhuma Receita Encontrada Nesse Periodo", HttpStatus.OK);
	}

	@GetMapping("/mostra_saldo_total_de_receita")
	public ResponseEntity<String> mostrasaldototal() {
		double saldoTotal = 0;
		for (int i = 1; i <= receitaRepository.count(); i++) {
			saldoTotal = receitaRepository.getById(i).getValor() + saldoTotal;
		}
		return new ResponseEntity<String>("O Saldo Total de receitas é " + saldoTotal, HttpStatus.OK);
	}

}