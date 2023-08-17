package com.client.belarosa.domain.dto;

import java.io.Serializable;

public class ProdutoNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Integer id;
    private String nome;
    private Double preco;
    private String descricao;
    private Integer categoria_id;
    private Integer sub_categoria_id;
    
    public ProdutoNewDTO() {}

	public ProdutoNewDTO(Integer id, String nome, Double preco, String descricao, Integer categoria_id, Integer sub_categoria_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.categoria_id = categoria_id;
		this.sub_categoria_id = sub_categoria_id;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	public Integer getSub_categoria_id() {
		return sub_categoria_id;
	}

	public void setSub_categoria_id(Integer sub_categoria_id) {
		this.sub_categoria_id = sub_categoria_id;
	}
}
