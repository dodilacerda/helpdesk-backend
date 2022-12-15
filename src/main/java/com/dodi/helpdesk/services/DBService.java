package com.dodi.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodi.helpdesk.domain.Chamado;
import com.dodi.helpdesk.domain.Cliente;
import com.dodi.helpdesk.domain.Tecnico;
import com.dodi.helpdesk.domain.enums.Perfil;
import com.dodi.helpdesk.domain.enums.Prioridade;
import com.dodi.helpdesk.domain.enums.Status;
import com.dodi.helpdesk.repositories.ChamadoRepository;
import com.dodi.helpdesk.repositories.ClienteRepository;
import com.dodi.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "247.930.150-21", "dodi2@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "826.114.640-30", "Linus2@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 02", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
