package br.com.desafiopubfuture.desafio.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.desafiopubfuture.desafio.model.Conta;
import br.com.desafiopubfuture.desafio.repository.ContaRepository;
import br.com.desafiopubfuture.desafio.repository.DespesaRepository;
import br.com.desafiopubfuture.desafio.repository.ReceitaRepository;
import io.restassured.http.ContentType;

@WebMvcTest
public class contaControllerTest {

	@Autowired
	private ContaController contaController;
	
	@MockBean
	private ContaRepository contaRepository;
	@MockBean
	private DespesaRepository despesaRepository;
	@MockBean
	private ReceitaRepository receitaRepository;
	@BeforeEach
	public void setup() {
		standaloneSetup(this.contaController);
	}
	@Test
	public void deveRetornarSucesso_salvandoUmaNovaConta( ) {
		Conta conta = new Conta(1,333,"corrente",500,777,"bradesco");
		when(this.contaController.adicionar(conta));
		given().accept(ContentType.JSON).get("conta/adicionar",conta).then().statusCode(HttpStatus.OK.value());
	}
	
}
