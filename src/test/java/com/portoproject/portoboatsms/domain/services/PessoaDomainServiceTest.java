package com.portoproject.portoboatsms.domain.services;

import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.dto.mapper.PessoaMapper;
import com.portoproject.portoboatsms.domain.entities.Pessoa;
import com.portoproject.portoboatsms.domain.exceptions.CpfJaCadastradoException;
import com.portoproject.portoboatsms.domain.exceptions.InternalServerErrorExcpetion;
import com.portoproject.portoboatsms.domain.exceptions.TelefoneInvalidoOuCpfInvalidoExcpetion;
import com.portoproject.portoboatsms.domain.repository.PessoaRepository;
import com.portoproject.portoboatsms.mocks.PessoaMocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
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
    private Pessoa pessoa;
    PessoaObterResponse pessoaObterResponse;

    @Test
    void deveRetornarUmaPessoaObterResponseQuandoReceberUmaPessoaSalvarResquestValido() {
        dadoUmaPessoaSalvarResquestValido();
        dadoQueRepositoryExistByCpfRetornaFalse();
        dadoQueRepositorySalvaComSucesso();
        quandoServiceSalvarComSucesso();
        entaoEsperaQueOsAtributosSejamIguais();


    }

    @Test
    void deveSoltarUmTelefoneInvalidoOuCpfExceptionQuandoReceberTelefoneInvalidoOuCpfInvalido() {

        dadoUmaPessoaSalvarResquestComCpfOuTelefoneInvalido();
        quandoServiceSalvarDeveSoltarUmaException();

    }

    @Test
    void deveSoltarUmCpfJaCadastradoExceptionQuandoTentarSalvarUmCpfQueJaTenhaCadastrado() {

        dadoUmaPessoaSalvarRequestMesmoCpf();
        dadoQueRepositoryExistByCpfRetornaTrue();
        quandoPessoaDomainServiceSalvarDeveRetornarUmaExecptionCpfJaCadastrado();
    }

    @Test
    void deveSoltarUmInternalServerErrorExeptionQuandoFalharAComunicacaoComODb() {

        dadoUmaPessoaSalvarRequestCpfExistente();
        dadoQueRepositoryExistByCpfRetornaRuntimeException();
        quandoPessoaDomainServiceSalvarDeveRetornarUmaInternalServerErrorExcpetion();
    }
    // GIVEN/DADO METHODS

    private void dadoUmaPessoaSalvarResquestComCpfOuTelefoneInvalido() {
        pessoaSalvarRequest = PessoaMocks.InvalidPessoaSalvarRequestCPFInvalidoOuTelefoneInvalido();

    }

    private void dadoQueRepositorySalvaComSucesso() {
        when(pessoaRepository.save(any())).thenReturn(PessoaMocks.validPessoa());
    }

    private void dadoQueRepositoryExistByCpfRetornaFalse() {
        when(pessoaRepository.existsByCpf(ArgumentMatchers.any())).thenReturn(false);

    }

    private void dadoUmaPessoaSalvarResquestValido() {
        pessoaSalvarRequest = PessoaMocks.validPessoaSalvarRequest();

    }
    private void dadoQueRepositoryExistByCpfRetornaTrue() {
        when(pessoaRepository.existsByCpf(ArgumentMatchers.any())).thenReturn(true);

    }

    private void dadoUmaPessoaSalvarRequestMesmoCpf() {
        pessoaSalvarRequest = PessoaMocks.validPessoaSalvarRequest();
    }

    private void dadoQueRepositoryExistByCpfRetornaRuntimeException() {
        when(pessoaRepository.existsByCpf(any())).thenThrow(RuntimeException.class);

    }
    private void dadoUmaPessoaSalvarRequestCpfExistente() {
        pessoaSalvarRequest=PessoaMocks.validPessoaSalvarRequest();
    }
    // WHEN/QUANDO METHODS
    private void quandoServiceSalvarComSucesso() {
        pessoaObterResponse = pessoaDomainService.salvar(pessoaSalvarRequest);
    }

    private void quandoServiceSalvarDeveSoltarUmaException() {
        Assertions.assertThrows(TelefoneInvalidoOuCpfInvalidoExcpetion.class, () ->
                pessoaDomainService.salvar(pessoaSalvarRequest)
        );
    }
    private void quandoPessoaDomainServiceSalvarDeveRetornarUmaExecptionCpfJaCadastrado() {
        Assertions.assertThrows(CpfJaCadastradoException.class, () ->
                pessoaDomainService.salvar(pessoaSalvarRequest)
        );
    }
    private void quandoPessoaDomainServiceSalvarDeveRetornarUmaInternalServerErrorExcpetion() {
        Assertions.assertThrows(InternalServerErrorExcpetion.class, () ->
                pessoaDomainService.salvar(pessoaSalvarRequest));
    }
    // THEN/ENTAO METHODS

    private void entaoEsperaQueOsAtributosSejamIguais() {
        assertEquals(pessoaSalvarRequest.getNome(), pessoaObterResponse.getNome());
        assertEquals(pessoaSalvarRequest.getTipo(), pessoaObterResponse.getTipo());
        assertEquals(pessoaSalvarRequest.getCpf(), pessoaObterResponse.getCpf());
        assertEquals(pessoaSalvarRequest.getEmail(), pessoaObterResponse.getEmail());
        assertEquals(pessoaSalvarRequest.getTelefone(), pessoaObterResponse.getTelefone());
    }

    //
    @Test
    void deveRetornarUmaListaComTodasAsPessoasQuandoEssasPessoasEstiveremSalvasNoBanco(){
        //inst das entidades
        PessoaObterResponse obterResponse = new PessoaObterResponse();
        Pessoa pessoa = new Pessoa();
        obterResponse.setId(pessoa.getId());

        //add list
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(pessoa);
        List<PessoaObterResponse> expectedPessoaObterResponseList = new ArrayList<>();
        expectedPessoaObterResponseList.add(obterResponse);
        when(pessoaRepository.findAll()).thenReturn(pessoaList);

        //result service
        List<PessoaObterResponse> actualPessoaObterResponseList = pessoaDomainService.obterTodasAsPeSssoas();
        //comparação esperado com o atual
        assertEquals(expectedPessoaObterResponseList, actualPessoaObterResponseList);


    }
}
