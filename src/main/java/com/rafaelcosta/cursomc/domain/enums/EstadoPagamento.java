package com.rafaelcosta.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	//constructor de tipo enum deve ser private
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	} 

	public int getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static EstadoPagamento ToEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento x: EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException(String.format("Id inválido: %d", cod));
	}
}
