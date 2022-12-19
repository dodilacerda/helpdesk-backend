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
		tec1.addPerfil(Perfil.TECNICO);
		Tecnico tec2 = new Tecnico(null, "Jorge Lacerda", "486.222.310-97", "Jorge@mail.com", "123");
		tec2.addPerfil(Perfil.ADMIN);
		Tecnico tec3 = new Tecnico(null, "Dodi Lacerda", "317.616.830-63", "dodao@mail.com", "123");
		tec3.addPerfil(Perfil.TECNICO);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "826.114.640-30", "Linus2@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Nome Qualquer", "710.950.280-57", "nome@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 02", "Segunda chamado", tec3, cli2);
		Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 03", "Terceiro chamado", tec2, cli2);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		tecnicoRepository.saveAll(Arrays.asList(tec2));
		tecnicoRepository.saveAll(Arrays.asList(tec3));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		clienteRepository.saveAll(Arrays.asList(cli2));
		
		chamadoRepository.saveAll(Arrays.asList(c1));
		chamadoRepository.saveAll(Arrays.asList(c2));
		chamadoRepository.saveAll(Arrays.asList(c3));
	}
}
