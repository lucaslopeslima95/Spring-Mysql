package br.com.desafiopubfuture.desafio.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopubfuture.desafio.model.Receita;
import br.com.desafiopubfuture.desafio.repository.ReceitasRepository;

@RestController
@RequestMapping("/clientes")
public class controleFinanceiroControler {
	
	@Autowired
	private ReceitasRepository repositoryCliente;
	
	@GetMapping
	public List<Receita> listar() {
		return repositoryCliente.findAll();
	}
	
	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
	public Receita adicionar(@RequestBody Receita cliente) {
		return repositoryCliente.save(cliente);
		
	}

}
