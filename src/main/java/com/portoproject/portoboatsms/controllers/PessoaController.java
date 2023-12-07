package com.portoproject.portoboatsms.controllers;

import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.services.PessoaDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    PessoaDomainService pessoaDomainService;

    public PessoaController(PessoaDomainService pessoaDomainService) {
        this.pessoaDomainService = pessoaDomainService;
    }

    @GetMapping("/listAllPeople")
    public ResponseEntity<List<PessoaObterResponse>> getAllPeopleList(){
        List<PessoaObterResponse> listAll =pessoaDomainService.obterTodasAsPeSssoas();
        return ResponseEntity.ok(listAll);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaObterResponse createPessoa(@RequestBody PessoaSalvarRequest pessoaSalvarRequest) {
        return pessoaDomainService.salvar(pessoaSalvarRequest);
    }
}
