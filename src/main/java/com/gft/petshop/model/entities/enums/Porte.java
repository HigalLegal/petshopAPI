package com.gft.petshop.model.entities.enums;

public enum Porte {
	
	MEDIO("MEDIO"), PEQUENO("PEQUENO"), GRANDE("GRANDE");
	
	private String descricao;
	
	Porte(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
