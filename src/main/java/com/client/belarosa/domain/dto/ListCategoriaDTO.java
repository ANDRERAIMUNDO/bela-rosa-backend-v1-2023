package com.client.belarosa.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.client.belarosa.domain.Categoria;
import com.client.belarosa.domain.SubCategoria;

public class ListCategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
	private List<SubCategoria> sub_categorias = new ArrayList<>();
	
    public ListCategoriaDTO() {}
    
    public ListCategoriaDTO(Categoria obj) {
    	id = obj.getId();
    	nome = obj.getNome();
    	sub_categorias = obj.getSub_categorias();
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

	public List<SubCategoria> getSub_categorias() {
		return sub_categorias;
	}

	public void setSub_categorias(List<SubCategoria> sub_categorias) {
		this.sub_categorias = sub_categorias;
	}
}
