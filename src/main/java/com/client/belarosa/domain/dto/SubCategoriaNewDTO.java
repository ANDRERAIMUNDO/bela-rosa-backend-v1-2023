package com.client.belarosa.domain.dto;

import java.io.Serializable;

public class SubCategoriaNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	private String nome;
	private Integer categoria_id;
	
	public SubCategoriaNewDTO() {}

	public SubCategoriaNewDTO(Integer id, String nome, Integer categoria_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria_id = categoria_id;
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

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}
}
