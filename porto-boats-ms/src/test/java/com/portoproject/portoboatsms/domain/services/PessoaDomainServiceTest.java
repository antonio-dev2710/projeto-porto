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
    PessoaObterResponse pessoaObterResponse;

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
        dadoUmaPessoaSalvarResquestValido();
        dadoQueRepositoryExistByCpfRetornaFalse();
        dadoQueRepositorySalvaComSucesso();
        quandoServiceSalvarComSucesso();
        entaoEsperaQueOsAtributosSejamIguais();


    }

    private void entaoEsperaQueOsAtributosSejamIguais() {
        assertEquals(pessoaSalvarRequest.getNome(), pessoaObterResponse.getNome());
        assertEquals(pessoaSalvarRequest.getTipo(), pessoaObterResponse.getTipo());
        assertEquals(pessoaSalvarRequest.getCpf(), pessoaObterResponse.getCpf());
        assertEquals(pessoaSalvarRequest.getEmail(), pessoaObterResponse.getEmail());
        assertEquals(pessoaSalvarRequest.getTelefone(), pessoaObterResponse.getTelefone());
    }

    private void quandoServiceSalvarComSucesso() {
        pessoaObterResponse = pessoaDomainService.salvar(pessoaSalvarRequest);

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

    @Test
    void deveSoltarUmTelefoneInvalidoOuCpfExceptionQuandoReceberTelefoneInvalidoOuCpfInvalido() {
        //dadoUmaPessoaSalvarResquestValido();
        //quandoPessoaDomainServiceSalvar();
        //deveRetornarUmaExeptionCpfInvalidoOuTelefoneInvalido();
        //assertEquals(pessoaSalvarRequest.getTelefone().length(), pessoaSalva.getTelefone().length());

        dadoUmaPessoaSalvarResquestComCpfOuTelefoneInvalido();
        quandoServiceSalvarDeveSoltarUmaException();

    }


    private void quandoServiceSalvarDeveSoltarUmaException() {
        Assertions.assertThrows(TelefoneInvalidoOuCpfInvalidoExcpetion.class, () ->
                pessoaDomainService.salvar(pessoaSalvarRequest)
        );


    }

    private void dadoUmaPessoaSalvarResquestComCpfOuTelefoneInvalido() {
        pessoaSalvarRequest = PessoaMocks.InvalidPessoaSalvarRequestCPFInvalidoOuTelefoneInvalido();

    }

    @Test
    void deveSoltarUmCpfJaCadastradoExceptionQuandoTentarSalvarUmCpfQueJaTenhaCadastrado() {

        dadoUmaPessoaSalvarRequestMesmoCpf();
        dadoQueRepositoryExistByCpfRetornaTrue();
        quandoPessoaDomainServiceSalvarDeveRetornarUmaExecptionCpfJaCadastrado();
    }

    private void quandoPessoaDomainServiceSalvarDeveRetornarUmaExecptionCpfJaCadastrado() {
        Assertions.assertThrows(CpfJaCadastradoException.class, () ->
                pessoaDomainService.salvar(pessoaSalvarRequest)
        );
    }

    private void dadoQueRepositoryExistByCpfRetornaTrue() {
        when(pessoaRepository.existsByCpf(ArgumentMatchers.any())).thenReturn(true);

    }

    private void dadoUmaPessoaSalvarRequestMesmoCpf() {
        pessoaSalvarRequest = PessoaMocks.validPessoaSalvarRequest();
    }



    @Test
    void deveSoltarUmInternalServerErrorExeptionQuandoFalharAComunicacaoComODb() {

        dadoUmaPessoaSalvarRequestCpfExistente();
        dadoQueRepositoryExistByCpfRetornaRuntimeException();
        quandoPessoaDomainServiceSalvarDeveRetornarUmaInternalServerErrorExcpetion();






    }

    private void quandoPessoaDomainServiceSalvarDeveRetornarUmaInternalServerErrorExcpetion() {
        Assertions.assertThrows(InternalServerErrorExcpetion.class, () ->
                pessoaDomainService.salvar(pessoaSalvarRequest));
    }
    private void dadoQueRepositoryExistByCpfRetornaRuntimeException() {
        when(pessoaRepository.existsByCpf(any())).thenThrow(RuntimeException.class);

    }
    private void dadoUmaPessoaSalvarRequestCpfExistente() {
        pessoaSalvarRequest=PessoaMocks.validPessoaSalvarRequest();
    }


}
