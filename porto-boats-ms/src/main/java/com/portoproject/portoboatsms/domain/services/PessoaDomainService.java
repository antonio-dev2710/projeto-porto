package com.portoproject.portoboatsms.domain.services;

import java.util.List;

import com.portoproject.portoboatsms.domain.dto.PessoaAtualizarRequest;
import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.repository.PessoaRepository;
import com.portoproject.portoboatsms.domain.services.interfaces.PessoaService;

public class PessoaDomainService implements PessoaService {

    private int numComprimentoCpf = 11;
    private int numComprimentoTelefone = 12;

    //private PessoaRepository pessoaRepository;


    @Override
    public List<PessoaObterResponse> obterTodasAsPeSssoas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaSalvarRequest salvar(PessoaSalvarRequest pessoaObterResponse)  {

        if (pessoaObterResponse.getTelefone().length() < numComprimentoTelefone
                && pessoaObterResponse.getCpf().length() < numComprimentoCpf) {
            System.out.println("Deu ruim");
            return null;

        }
        //aqq euvou converter para entidade o dto

        return pessoaObterResponse;
    }

    @Override
    public PessoaObterResponse obterPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaObterResponse atualizar(PessoaAtualizarRequest pessoaAtualizarRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaObterResponse deletar(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

}
