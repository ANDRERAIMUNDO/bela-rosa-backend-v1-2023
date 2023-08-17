package com.client.belarosa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Destaque implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String quadro;
    
    @Length(min = 3, max = 2000)
    private String quadro_descricao;
    private Integer produto_id;
    private String nome;
    private Double preco; 
    
    public Destaque() {}

    
	public Destaque(Integer id, String quadro,String quadro_descricao, Integer produto_id,
			String nome, Double preco) {
		super();
		this.id = id;
		this.quadro = quadro;
		this.quadro_descricao = quadro_descricao;
		this.produto_id = produto_id;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getQuadro() {
		return quadro;
	}


	public void setQuadro(String quadro) {
		this.quadro = quadro;
	}


	public String getQuadro_descricao() {
		return quadro_descricao;
	}


	public void setQuadro_descricao(String quadro_descricao) {
		this.quadro_descricao = quadro_descricao;
	}


	public Integer getProduto_id() {
		return produto_id;
	}


	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


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
		Destaque other = (Destaque) obj;
		return Objects.equals(id, other.id);
	}
}
