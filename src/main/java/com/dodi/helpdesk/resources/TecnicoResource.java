package com.dodi.helpdesk.resources;

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

}
