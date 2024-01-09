package com.rafaelcosta.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcosta.cursomc.domain.Categoria;
import com.rafaelcosta.cursomc.repositories.CategoriaRepository;
import com.rafaelcosta.cursomc.services.exceptions.ObjectNotFoundException;

@Service //Identificador de serviço no spring
public class CategoriaService {
	
	@Autowired //Anotação de instanciação de dependência
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		//return obj.orElse(null); //antigo
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Objeto não encontrado! Id: %d, Tipo: %s", id, Categoria.class.getName())));
	}
	
	/* testes a ser removido depois */
	public List<Categoria> findAll(){
		List<Categoria> categorias = repo.findAll();
		return categorias;
	}
}
