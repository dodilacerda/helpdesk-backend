package com.dodi.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dodi.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
