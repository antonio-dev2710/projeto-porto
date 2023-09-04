package com.portoproject.portoboatsms.domain.dto;


import com.portoproject.portoboatsms.domain.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PessoaSalvarRequest {


    private String nome;
    private String tipo;
    private String email;
    private String telefone;
    private String cpf;
    public Pessoa toPessoa(){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(this,pessoa);
        return pessoa;
    }


}
