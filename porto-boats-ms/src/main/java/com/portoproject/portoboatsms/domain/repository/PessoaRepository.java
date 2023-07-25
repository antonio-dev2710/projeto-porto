package com.portoproject.portoboatsms.domain.repository;

import com.portoproject.portoboatsms.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {
}
