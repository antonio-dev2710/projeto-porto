package com.portoproject.portoboatsms.mocks;

import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.entities.Pessoa;

public class PessoaMocks {
    public static PessoaSalvarRequest validPessoaSalvarRequest(){
        return PessoaSalvarRequest.builder()
                .nome("Carlos Pereira")
                .cpf("12507205750")
                .email("carloso.pereira@hotmail")
                .telefone("7493700-7734")
                .tipo("Gerente")
                .build();

    }
    public static Pessoa validPessoa(){
        return validPessoaSalvarRequest().toPessoa();
    }
}
