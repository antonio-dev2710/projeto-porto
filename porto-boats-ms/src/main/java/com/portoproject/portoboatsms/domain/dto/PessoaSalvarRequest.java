package com.portoproject.portoboatsms.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PessoaSalvarRequest {

    private String id= UUID.randomUUID().toString();
    private String nome;
    private String tipo;
    private String email;
    private String telefone;
    private String cpf;


}
