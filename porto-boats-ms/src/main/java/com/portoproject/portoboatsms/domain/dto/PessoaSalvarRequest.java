package com.portoproject.portoboatsms.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaSalvarRequest {

	    private String nome;
	    private String tipo;
	    private String email;
	    private String telefone;
}
