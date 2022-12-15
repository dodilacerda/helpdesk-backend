package com.dodi.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dodi.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
