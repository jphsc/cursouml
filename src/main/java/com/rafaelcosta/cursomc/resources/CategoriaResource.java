package com.rafaelcosta.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelcosta.cursomc.domain.Categoria;
import com.rafaelcosta.cursomc.services.CategoriaService;

@RestController //Informativo de ser um endpoint (controlador rest)
@RequestMapping(value="/categorias") //informativo do path do endpoint
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	/* testes a ser removido depois */
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> findAll() {
		
		return service.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET) //Informativo de cair nesse endpoint se for um get
	//	public List<Categoria> find(@PathVariable Integer id) {
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}

