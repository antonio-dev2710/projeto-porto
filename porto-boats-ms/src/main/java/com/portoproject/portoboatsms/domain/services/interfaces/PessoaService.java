package com.portoproject.portoboatsms.domain.services.interfaces;

import java.util.List;

import com.portoproject.portoboatsms.domain.dto.PessoaAtualizarRequest;
import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.entities.Pessoa;

public interface PessoaService {

	List<PessoaObterResponse> obter();

	PessoaObterResponse salvar(PessoaSalvarRequest pessoaSalvarRequest);

	PessoaObterResponse obterPorNome(String nome);

	PessoaObterResponse atualizar(PessoaAtualizarRequest pessoaAtualizarRequest);

	PessoaObterResponse deletar(String nome);

}
