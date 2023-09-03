package com.portoproject.portoboatsms.domain.services;

import java.util.List;

import com.portoproject.portoboatsms.domain.dto.PessoaAtualizarRequest;
import com.portoproject.portoboatsms.domain.dto.PessoaObterResponse;
import com.portoproject.portoboatsms.domain.dto.PessoaSalvarRequest;
import com.portoproject.portoboatsms.domain.dto.mapper.PessoaMapper;
import com.portoproject.portoboatsms.domain.entities.Pessoa;
import com.portoproject.portoboatsms.domain.repository.PessoaRepository;
import com.portoproject.portoboatsms.domain.services.interfaces.PessoaService;

public class PessoaDomainService implements PessoaService {

    private int numComprimentoCpf = 11;
    private int numComprimentoTelefone = 12;


    private PessoaRepository pessoaRepository;
    private PessoaMapper pessoaMapper;

    public PessoaDomainService(PessoaMapper pessoaMapper,PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaMapper = pessoaMapper;
    }

    @Override
    public List<PessoaSalvarRequest> obterTodasAsPeSssoas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaObterResponse salvar(PessoaSalvarRequest pessoaSalvarRequest)  {

        if (pessoaSalvarRequest.getTelefone().length() != numComprimentoTelefone
                || pessoaSalvarRequest.getCpf().length() != numComprimentoCpf) {
            System.out.println("Deu ruim");
            return null;

        }

        if(pessoaRepository.existsByCpf(pessoaSalvarRequest.getCpf())){
            System.out.println("Deu ruim");
            return null;
        }
        //aqq eu vou converter para dto para entidade
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaSalvarRequest.getNome());
        pessoa.setCpf(pessoaSalvarRequest.getCpf());
        pessoa.setTipo(pessoaSalvarRequest.getTipo());
        pessoa.setEmail(pessoaSalvarRequest.getEmail());
        pessoa.setTelefone(pessoaSalvarRequest.getTelefone());

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        //converter entidade para dto de response
        PessoaObterResponse pessoaObterResponse = new PessoaObterResponse();
        pessoaObterResponse.setId(pessoaSalva.getId());
        pessoaObterResponse.setNome(pessoaSalva.getNome());
        pessoaObterResponse.setCpf(pessoaSalva.getCpf());
        pessoaObterResponse.setTipo(pessoaSalva.getTipo());
        pessoaObterResponse.setEmail(pessoaSalva.getEmail());
        pessoaObterResponse.setTelefone(pessoaSalva.getTelefone());

        return pessoaObterResponse;

        //return pessoaMapper.toDTO(pessoaRepository.save(pessoaMapper.toEntityPessoa(pessoaSalvarRequest)));

    }

    @Override
    public PessoaObterResponse obterPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaObterResponse atualizar(PessoaAtualizarRequest pessoaAtualizarRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PessoaObterResponse deletar(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

}
