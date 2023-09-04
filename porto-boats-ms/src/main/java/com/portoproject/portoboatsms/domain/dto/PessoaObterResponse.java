package com.portoproject.portoboatsms.domain.dto;

import com.portoproject.portoboatsms.domain.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

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

    public static PessoaObterResponse from(final Pessoa pessoa){
        PessoaObterResponse pessoaObterResponse=new PessoaObterResponse();
        BeanUtils.copyProperties(pessoa,pessoaObterResponse);
        return pessoaObterResponse;
    }


}
