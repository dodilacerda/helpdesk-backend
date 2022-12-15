package com.dodi.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dodi.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
