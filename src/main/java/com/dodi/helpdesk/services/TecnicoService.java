package com.dodi.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodi.helpdesk.domain.Tecnico;
import com.dodi.helpdesk.domain.dtos.TecnicoDTO;
import com.dodi.helpdesk.repositories.TecnicoRepository;
import com.dodi.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findByid(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		//Assegura o Id nulo para o banco, pois pode ser que venha algum id na requisição e o BD entenda que é um update.
		objDTO.setId(null);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);//Chamada assíncrona: primeiro salva e depois retorna o newObj.
	}
}
