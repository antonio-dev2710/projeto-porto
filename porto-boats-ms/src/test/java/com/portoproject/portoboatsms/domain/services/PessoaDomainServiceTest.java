package com.portoproject.portoboatsms.domain.services;

import java.util.List;

import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@ExtendWith(value = SpringExtension.class)
public class PessoaDomainServiceTest {
	private PessoaDomainService pessoaDomainService;
	private PessoaSalvarRequest pessoaSalvarRequest;
	private PessoaSalvarRequest pessoaSalva;


	
	@BeforeEach
	void deveEstabelecerAntesDeCadaTeste(){
		//espero que aconteça isso
		pessoaSalvarRequest = new PessoaSalvarRequest();
		pessoaSalvarRequest.setNome("Carlos Pereira");
		pessoaSalvarRequest.setEmail("carloso.pereira@hotmail");
		pessoaSalvarRequest.setTipo("Gerente");
		pessoaSalvarRequest.setTelefone("7493700-7734");
		pessoaSalvarRequest.setCpf("12507205750");
		PessoaRepository pessoaRepository;

		pessoaDomainService =new PessoaDomainService();

		pessoaSalva=pessoaDomainService.salvar(pessoaSalvarRequest);

	}
	@Test
	void deveRetornarUmaPessoaObterResponseQuandoReceberUmaPessoaSalvarResquestValido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();

		assertEquals(pessoaSalvarRequest, pessoaSalva);
	
		
	}
	
	@Test
	void deveSoltarUmBadRequestExeptionQuandoReceberCpfInvalido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		//criar o bojeto

		assertEquals(pessoaSalvarRequest.getCpf().length(), pessoaSalva.getCpf().length());
	
		
	}
	
	@Test
	void deveSoltarUmBadRequestExeptionQuandoReceberTelefoneInvalido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		assertEquals(pessoaSalvarRequest.getTelefone().length(), pessoaSalva.getTelefone().length());
	
		
	}
	
	@Test
	void deveSoltarUmInternalServerErrorExeptionQuandoFalharAComunicacaoComODb() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		PessoaSalvarRequest pessoaSalvarRequest = new PessoaSalvarRequest();

	
		
	}
	

}
