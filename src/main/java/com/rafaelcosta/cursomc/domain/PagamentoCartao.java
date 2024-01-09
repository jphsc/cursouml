package com.rafaelcosta.cursomc.domain;

import com.rafaelcosta.cursomc.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;
	
	private PagamentoCartao() {}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
}
