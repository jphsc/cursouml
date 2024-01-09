package com.rafaelcosta.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcosta.cursomc.domain.Cliente;
import com.rafaelcosta.cursomc.repositories.ClienteRepository;
import com.rafaelcosta.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository _repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = _repo.findById(id);
		//return obj.orElse(null); //antigo
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Objeto não encontrado! Id: %d, Tipo: %s", id, Cliente.class.getName())));
	}
	
	/* testes a ser removido depois */
	public List<Cliente> findAll(){
		List<Cliente> clientes = _repo.findAll();
		return clientes;
	}
}
