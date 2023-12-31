package com.client.belarosa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nome;
	
	@ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();
	
	@OneToMany(mappedBy="categoria", cascade = CascadeType.ALL)
	private List<SubCategoria> sub_categorias = new ArrayList<>();
	  
	public Categoria() {
}

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
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<SubCategoria> getSub_categorias() {
		return sub_categorias;
	}

	public void setSub_categorias(List<SubCategoria> sub_categorias) {
		this.sub_categorias = sub_categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}