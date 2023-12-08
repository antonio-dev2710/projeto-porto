package com.portoproject.portoboatsms.domain.services.interfaces;

import java.util.List;

import com.portoproject.portoboatsms.domain.dto.PessoaAtualizarRequest;
import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;

public interface PessoaService {

	List<PessoaObterResponse> obterTodasAsPeSssoas();

	PessoaObterResponse salvar(PessoaSalvarRequest PessoaObterResponse);

	PessoaObterResponse obterPorId(String id);

	PessoaObterResponse atualizar(PessoaAtualizarRequest pessoaAtualizarRequest);

	PessoaObterResponse deletar(String id);

}
