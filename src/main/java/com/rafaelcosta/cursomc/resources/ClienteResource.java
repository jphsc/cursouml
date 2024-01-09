package com.rafaelcosta.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelcosta.cursomc.domain.Cliente;
import com.rafaelcosta.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService _clienteService;

//	@RequestMapping(method=RequestMethod.GET)
//	public List<Cliente> findAll() {
//		
//		return _clienteService.findAll();
//	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET) //Informativo de cair nesse endpoint se for um get
	//	public List<Categoria> find(@PathVariable Integer id) {
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cliente obj = _clienteService.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}