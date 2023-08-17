package com.client.belarosa.domain.dto;

import java.io.Serializable;

public class ImagemNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	private String url;
	private Integer produto_id;
	
	public ImagemNewDTO () {}

	public ImagemNewDTO(Integer id, String url, Integer produto_id) {
		super();
		this.id = id;
		this.url = url;
		this.produto_id = produto_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}
}