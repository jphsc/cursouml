package com.rafaelcosta.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaelcosta.cursomc.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
//	JpaRepository > É uma interface que implementa métodos de repositório: para CRUD
//	aceita o tipo de objeto E o tipo do identificar desse objeto na entidade
//	um objeto do tipo: CategoriaRepository poderá realizar operações crud de objetos do tipo categoria
}
