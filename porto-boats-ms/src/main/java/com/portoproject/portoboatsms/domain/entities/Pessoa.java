package com.portoproject.portoboatsms.domain.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Builder.Default
    private String id=UUID.randomUUID().toString();
    private String nome;
    private String tipo;
    private String email;
    private String telefone;
    private String cpf;
    private boolean ativo=true;
    
    




}
