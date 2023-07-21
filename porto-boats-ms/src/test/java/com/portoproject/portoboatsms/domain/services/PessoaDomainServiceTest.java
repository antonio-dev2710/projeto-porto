package com.portoproject.portoboatsms.domain.services;

import java.util.List;

import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@ExtendWith(value = SpringExtension.class)
public class PessoaDomainServiceTest {
	private PessoaDomainService pessoaDomainService;
	PessoaSalvarRequest pessoaSalvarRequest;
	
	@BeforeEach
	void deveEstabelecerAntesDeCadaTeste(){
		pessoaSalvarRequest = new PessoaSalvarRequest();
		pessoaSalvarRequest.setNome("Carlos Pereira");
		pessoaSalvarRequest.setEmail("carloso.pereira@hotmail");
		pessoaSalvarRequest.setTipo("Gerente");
		pessoaSalvarRequest.setTelefone("(74)93700-7734");
		pessoaSalvarRequest.setCpf("12507205750");

	}
	@Test
	void deveRetornarUmaPessoaObterResponseQuandoReceberUmaPessoaSalvarResquestValido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();

		assertEquals(pessoaSalvarRequest, pessoaDomainService);
	
		
	}
	
	@Test
	void deveSoltarUmBadRequestExeptionQuandoReceberCpfInvalido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		//criar o bojeto

		assertEquals(pessoaSalvarRequest.getCpf().length(), pessoaDomainService);
	
		
	}
	
	@Test
	void deveSoltarUmBadRequestExeptionQuandoReceberTelefoneInvalido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		assertEquals(pessoaSalvarRequest.getTelefone().length(), pessoaDomainService);
	
		
	}
	
	@Test
	void deveSoltarUmInternalServerErrorExeptionQuandoFalharAComunicacaoComODb() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		PessoaSalvarRequest pessoaSalvarRequest = new PessoaSalvarRequest();
		//criar o bojeto
	
		
	}
	

}
