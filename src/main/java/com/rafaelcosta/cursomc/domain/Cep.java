package com.rafaelcosta.cursomc.domain;

import java.io.Serializable;

public class Cep implements Serializable{

//	private static final long serialVersionUID = 1L;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer ibge;
	private Integer ddd;
	private Integer siafi;
	
	public Cep(String cep, String logradouro, String complemento, String bairro, String cidade, String estado,
			Integer ibge, Integer ddd, Integer siafi) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.ibge = ibge;
		this.ddd = ddd;
		this.siafi = siafi;
	}
}
