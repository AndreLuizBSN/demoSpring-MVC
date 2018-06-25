package com.mballem.curso.boot.domain;

public enum EntradaSaida {
	ENTRADA("Entrada"),
	SAIDA("Saída");
	
	private String descricao;
	
	EntradaSaida(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
