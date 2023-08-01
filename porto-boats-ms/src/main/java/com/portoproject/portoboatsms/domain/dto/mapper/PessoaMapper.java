package com.portoproject.portoboatsms.domain.dto.mapper;

import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.entities.Pessoa;

import org.springframework.stereotype.Component;

public class PessoaMapper {
/*
    public PessoaSalvarRequest toDTO(Pessoa pessoa) {
        if (pessoa == null) {
            return null;
        }
        return new PessoaSalvarRequest(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getTipo(),
                pessoa.getEmail(),
                pessoa.getTelefone(),
                pessoa.getCpf());

    }


    public Pessoa toEntityPessoa(PessoaSalvarRequest pessoaSalvarRequest){

        if(pessoaSalvarRequest == null){
            return null;
        }
        Pessoa pessoa = new Pessoa();


        if(pessoaSalvarRequest.getId()!=null){
            pessoa.setId(pessoaSalvarRequest.getId());

        }
        pessoa.setNome(pessoaSalvarRequest.getNome());
        pessoa.setTipo(pessoaSalvarRequest.getTipo());
        pessoa.setEmail(pessoaSalvarRequest.getEmail());
        pessoa.setTelefone(pessoaSalvarRequest.getTelefone());
        pessoa.setCpf(pessoaSalvarRequest.getCpf());

        return pessoa;
    }

 */
}

