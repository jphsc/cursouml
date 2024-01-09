package com.rafaelcosta.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity //Declara que essa classe sera uma entidade pelo JPA
@Table(name="categoria")
public class Categoria implements Serializable {
	
	//Necessário implementar Serializable e criar o atributo de versão abaixo
	private static final long serialVersionUID = 1L;
	
	@Id //Identificador de pk da entidade
	@Column(name="idcategoria", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY) //estratégia de geração automática de ID
	private Integer id;
	private String nome;
	
	//@JsonManagedReference //referencia gerenciada pelo Json [precisa ser do lado que se quer que venha os dados]
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>(); //Um produto tem uma ou mais categoria
	
	public Categoria() {}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return uma lista de produtos
	 * */
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	//Necessário criar o hashcode e equals para comparar (relacionar registros) valores 
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
}
