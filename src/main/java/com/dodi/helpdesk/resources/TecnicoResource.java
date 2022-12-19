package com.dodi.helpdesk.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dodi.helpdesk.domain.Tecnico;
import com.dodi.helpdesk.domain.dtos.TecnicoDTO;
import com.dodi.helpdesk.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;
	
	//ResponseEntity Trabalha toda resposta http.
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		Tecnico obj = service.findByid(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
	//Esse método será chamado quando não houver nenhum parâmetro passado no método acima.
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll(){
		//Primeiro pega uma lista da classe Tecnico.
		//Depois cria o objeto pela classe TecnicoDTO através da list criada anteriormente para garantir a segurança.
		List<Tecnico> list = service.findAll();
		List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}

}
