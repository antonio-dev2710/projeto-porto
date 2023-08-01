package com.portoproject.portoboatsms.domain.services.interfaces;

import java.util.List;

import com.portoproject.portoboatsms.domain.dto.PessoaAtualizarRequest;
import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;

public interface PessoaService {

	List<PessoaSalvarRequest> obterTodasAsPeSssoas();

	PessoaObterResponse salvar(PessoaSalvarRequest PessoaObterResponse);

	PessoaObterResponse obterPorNome(String nome);

	PessoaObterResponse atualizar(PessoaAtualizarRequest pessoaAtualizarRequest);

	PessoaObterResponse deletar(String nome);

}
