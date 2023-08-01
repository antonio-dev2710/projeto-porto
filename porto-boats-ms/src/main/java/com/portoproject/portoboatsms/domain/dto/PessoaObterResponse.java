package com.portoproject.portoboatsms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
