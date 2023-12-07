package com.portoproject.portoboatsms.domain.dto;

import com.portoproject.portoboatsms.domain.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaObterResponse {

    private String id;
    private String nome;
    private String tipo;
    private String email;
    private String telefone;
    private String cpf;
    private boolean ativo = true;

    public static PessoaObterResponse from(final Pessoa pessoa){
        PessoaObterResponse pessoaObterResponse=new PessoaObterResponse();
        BeanUtils.copyProperties(pessoa,pessoaObterResponse);
        return pessoaObterResponse;
    }

    public static List<PessoaObterResponse> from(final List <Pessoa> pessoa){
       List <PessoaObterResponse> pessoaObterResponseList=new ArrayList<>();
        PessoaObterResponse pessoaObterResponse=new PessoaObterResponse();

       for (Pessoa pessoas: pessoa) {
           BeanUtils.copyProperties(pessoas, pessoaObterResponse);
           pessoaObterResponseList.add(pessoaObterResponse);
       }


        return pessoaObterResponseList;
    }



}
