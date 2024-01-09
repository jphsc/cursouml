package com.rafaelcosta.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcosta.cursomc.domain.Pedido;
import com.rafaelcosta.cursomc.repositories.PedidoRepository;
import com.rafaelcosta.cursomc.services.exceptions.ObjectNotFoundException;

@Service //Identificador de serviço no spring
public class PedidoService {
	
	@Autowired //Anotação de instanciação de dependência
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		//return obj.orElse(null); //antigo
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Objeto não encontrado! Id: %d, Tipo: %s", id, Pedido.class.getName().toString())));
	}
	
	/* testes a ser removido depois */
	public List<Pedido> findAll(){
		List<Pedido> pedidos = repo.findAll();
		return pedidos;
	}
}
