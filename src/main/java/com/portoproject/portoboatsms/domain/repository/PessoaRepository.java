package com.portoproject.portoboatsms.domain.repository;


import com.portoproject.portoboatsms.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    Boolean existsByCpf(String cpf);
    //vou fzr uma query constumizada
    @Query("SLECT p from Pessoa p Where p.id = :id")
    Pessoa customAcharPorId(@Param("id") String id);

}
