package com.portoproject.portoboatsms.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.portoproject.portoboatsms.domain.dto.PessoaAtualizarRequest;
import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.dto.mapper.PessoaMapper;
import com.portoproject.portoboatsms.domain.entities.Pessoa;
import com.portoproject.portoboatsms.domain.exceptions.CpfJaCadastradoException;
import com.portoproject.portoboatsms.domain.exceptions.InternalServerErrorExcpetion;
import com.portoproject.portoboatsms.domain.exceptions.PessoaNaoEncontradaExcpetion;
import com.portoproject.portoboatsms.domain.exceptions.TelefoneInvalidoOuCpfInvalidoExcpetion;
import com.portoproject.portoboatsms.domain.repository.PessoaRepository;
import com.portoproject.portoboatsms.domain.services.interfaces.PessoaService;

public class PessoaDomainService implements PessoaService {

    private int numComprimentoCpf = 11;
    private int numComprimentoTelefone = 12;


    private PessoaRepository pessoaRepository;


    public PessoaDomainService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;

    }

    @Override
    public List<PessoaObterResponse> obterTodasAsPeSssoas() {
        //achar a lista
        List <Pessoa> listPessoa = pessoaRepository.findAll();
        //converter de entidade para Dto
        return PessoaObterResponse.from(listPessoa);
    }

    @Override
    public PessoaObterResponse salvar(PessoaSalvarRequest pessoaSalvarRequest) {

        try {

            if (pessoaSalvarRequest.getTelefone().length() != numComprimentoTelefone
                    || pessoaSalvarRequest.getCpf().length() != numComprimentoCpf) {

                throw new TelefoneInvalidoOuCpfInvalidoExcpetion();

            }

            if (pessoaRepository.existsByCpf(pessoaSalvarRequest.getCpf())) {
                throw new CpfJaCadastradoException();
            }
            //aqq eu vou converter de dto para entidade
            Pessoa pessoa = pessoaSalvarRequest.toPessoa();


            Pessoa pessoaSalva = pessoaRepository.save(pessoa);

            //converter entidade para dto de response
            return PessoaObterResponse.from(pessoaSalva);

        } catch (TelefoneInvalidoOuCpfInvalidoExcpetion | CpfJaCadastradoException ex) {
           throw  ex;
        } catch (Exception ex) {
            throw new InternalServerErrorExcpetion();
        }

    }


    @Override
    public PessoaObterResponse obterPorId(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaObterResponse atualizar(PessoaAtualizarRequest pessoaAtualizarRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaObterResponse deletar(String id) {
        Pessoa pessoa = pessoaRepository.customAcharPorId(id);
        if (pessoa.getId()==null){
            throw new PessoaNaoEncontradaExcpetion();
        }
        pessoa.setAtivo(false);
        //continuar ...
        return PessoaObterResponse.from(pessoa);
    }

}
