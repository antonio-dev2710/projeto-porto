package com.portoproject.portoboatsms.domain.services;

import java.util.List;

import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.dto.mapper.PessoaMapper;
import com.portoproject.portoboatsms.domain.entities.Pessoa;
import com.portoproject.portoboatsms.domain.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(value = SpringExtension.class)
public class PessoaDomainServiceTest {
	@Mock
	private PessoaRepository pessoaRepository;
	@Mock
	private PessoaMapper pessoaMapper;
	@InjectMocks
	private PessoaDomainService pessoaDomainService;
	private PessoaSalvarRequest pessoaSalvarRequest;
	private PessoaSalvarRequest pessoaSalva;
	private Pessoa pessoa;



	
	/*
	@BeforeEach
	void deveEstabelecerAntesDeCadaTeste(){
		//espero que aconteça isso
		pessoaSalvarRequest = new PessoaSalvarRequest();
		pessoaSalvarRequest.setNome("Carlos Pereira");
		pessoaSalvarRequest.setEmail("carloso.pereira@hotmail");
		pessoaSalvarRequest.setTipo("Gerente");
		pessoaSalvarRequest.setTelefone("7493700-7734");
		pessoaSalvarRequest.setCpf("12507205750");
		PessoaRepository pessoaRepository=null;
		PessoaMapper pessoaMapper = new PessoaMapper();


		//transforma o dto teste em entidade

		pessoaDomainService =new PessoaDomainService(pessoaMapper,pessoaRepository);

		pessoaSalva=pessoaDomainService.salvar(pessoaSalvarRequest);


	}

	 */
	@Test
	void deveRetornarUmaPessoaObterResponseQuandoReceberUmaPessoaSalvarResquestValido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		pessoaSalvarRequest = new PessoaSalvarRequest();
		pessoaSalvarRequest.setNome("Carlos Pereira");
		pessoaSalvarRequest.setEmail("carloso.pereira@hotmail");
		pessoaSalvarRequest.setTipo("Gerente");
		pessoaSalvarRequest.setTelefone("7493700-7734");
		pessoaSalvarRequest.setCpf("12507205750");

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaSalvarRequest.getNome());
		pessoa.setCpf(pessoaSalvarRequest.getCpf());
		pessoa.setTipo(pessoaSalvarRequest.getTipo());
		pessoa.setEmail(pessoaSalvarRequest.getEmail());
		pessoa.setTelefone(pessoaSalvarRequest.getTelefone());

		when(pessoaRepository.existsByCpf(ArgumentMatchers.any())).thenReturn(false);
		when(pessoaRepository.save(any())).thenReturn(pessoa);

		PessoaObterResponse pessoaObterResponse = pessoaDomainService.salvar(pessoaSalvarRequest);

		//TODO: COLOCAR OS OUTROS ATRIBUTOS
		assertEquals(pessoaSalvarRequest.getNome(),pessoaObterResponse.getNome());
		assertEquals(pessoaSalvarRequest.getTipo(),pessoaObterResponse.getTipo());
		assertEquals(pessoaSalvarRequest.getCpf(),pessoaObterResponse.getCpf());
		assertEquals(pessoaSalvarRequest.getEmail(),pessoaObterResponse.getEmail());
		assertEquals(pessoaSalvarRequest.getTelefone(),pessoaObterResponse.getTelefone());
	
		
	}
	
	@Test
	void deveRetornarNullQuandoReceberCpfInvalido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		//criar o bojeto
		pessoaSalvarRequest = new PessoaSalvarRequest();
		pessoaSalvarRequest.setNome("Carlos Pereira");
		pessoaSalvarRequest.setEmail("carloso.pereira@hotmail");
		pessoaSalvarRequest.setTipo("Gerente");
		pessoaSalvarRequest.setTelefone("7493700-7734");
		pessoaSalvarRequest.setCpf("1250720");

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaSalvarRequest.getNome());
		pessoa.setCpf(pessoaSalvarRequest.getCpf());
		pessoa.setTipo(pessoaSalvarRequest.getTipo());
		pessoa.setEmail(pessoaSalvarRequest.getEmail());
		pessoa.setTelefone(pessoaSalvarRequest.getTelefone());


		PessoaObterResponse pessoaObterResponse = pessoaDomainService.salvar(pessoaSalvarRequest);

		//TODO: COLOCAR OS OUTROS ATRIBUTOS
		assertNull(pessoaObterResponse);


	
		
	}
	
	@Test
	void deveRetornarNullQuandoReceberTelefoneInvalido() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		//assertEquals(pessoaSalvarRequest.getTelefone().length(), pessoaSalva.getTelefone().length());

		pessoaSalvarRequest = new PessoaSalvarRequest();
		pessoaSalvarRequest.setNome("Carlos Pereira");
		pessoaSalvarRequest.setEmail("carloso.pereira@hotmail");
		pessoaSalvarRequest.setTipo("Gerente");
		pessoaSalvarRequest.setTelefone("7493700");
		pessoaSalvarRequest.setCpf("12507205750");

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaSalvarRequest.getNome());
		pessoa.setCpf(pessoaSalvarRequest.getCpf());
		pessoa.setTipo(pessoaSalvarRequest.getTipo());
		pessoa.setEmail(pessoaSalvarRequest.getEmail());
		pessoa.setTelefone(pessoaSalvarRequest.getTelefone());


		PessoaObterResponse pessoaObterResponse = pessoaDomainService.salvar(pessoaSalvarRequest);

		//TODO: COLOCAR OS OUTROS ATRIBUTOS
		assertNull(pessoaObterResponse);
	
		
	}
	@Test
	void deveRetornarNullQuandoTentarSalvarUmCpfQueJaTenhaCadastrado(){
		//criar o bojeto
		pessoaSalvarRequest = new PessoaSalvarRequest();
		pessoaSalvarRequest.setNome("Carlos Pereira");
		pessoaSalvarRequest.setEmail("carloso.pereira@hotmail");
		pessoaSalvarRequest.setTipo("Gerente");
		pessoaSalvarRequest.setTelefone("7493700-7734");
		pessoaSalvarRequest.setCpf("1250720");

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaSalvarRequest.getNome());
		pessoa.setCpf(pessoaSalvarRequest.getCpf());
		pessoa.setTipo(pessoaSalvarRequest.getTipo());
		pessoa.setEmail(pessoaSalvarRequest.getEmail());
		pessoa.setTelefone(pessoaSalvarRequest.getTelefone());

		when(pessoaRepository.existsByCpf(ArgumentMatchers.any())).thenReturn(true);

		PessoaObterResponse pessoaObterResponse = pessoaDomainService.salvar(pessoaSalvarRequest);

		//TODO: COLOCAR OS OUTROS ATRIBUTOS
		assertNull(pessoaObterResponse);


	}
	
	@Test
	void deveSoltarUmInternalServerErrorExeptionQuandoFalharAComunicacaoComODb() {
		//dadoUmaPessoaSalvarResquestValido();
		//quandoPessoaDomainServiceSalvar();
		//deveRetornarUmaPessoaObterResponse();
		PessoaSalvarRequest pessoaSalvarRequest = new PessoaSalvarRequest();

	
		
	}
	

}
