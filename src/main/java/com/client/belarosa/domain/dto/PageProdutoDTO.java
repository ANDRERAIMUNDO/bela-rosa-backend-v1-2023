package com.client.belarosa.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.client.belarosa.domain.Imagem;
import com.client.belarosa.domain.Produto;

public class PageProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
	  private Integer id;
	  private String nome;
	  private Double preco;
	  private String descricao;
	  private List<Imagem> imagens = new ArrayList<>();
	  
	public PageProdutoDTO() {}

	public PageProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		preco = obj.getPreco();
		descricao = obj.getDescricao();
		imagens = obj.getImagens();
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

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
}
