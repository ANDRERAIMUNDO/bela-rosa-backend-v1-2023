package com.client.belarosa.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.belarosa.domain.Imagem;
import com.client.belarosa.domain.Produto;
import com.client.belarosa.domain.dto.ImagemNewDTO;
import com.client.belarosa.repositories.ImagemRepository;
import com.client.belarosa.repositories.ProdutoRepository;
import com.client.belarosa.service.exception.ObjectNotFoundException;

@Service
public class ImagemService {

	@Autowired
	ImagemRepository repository;
	
	@Autowired
	ProdutoRepository produto_repository;
	
	@Autowired
	ProdutoService produto_service;
	
	public Imagem create (ImagemNewDTO imagem) {
		Produto produto = produto_service.findById(imagem.getProduto_id());
		Imagem obj = new Imagem(null, imagem.getUrl());
		obj.getProdutos().addAll(Arrays.asList(produto));
		produto.getImagens().addAll(Arrays.asList(obj));
		repository.save(obj);
		produto_repository.save(produto);
		return obj;
	}
	
	public Imagem findById (Integer id) {
		Optional<Imagem> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Imagem.class.getName()));
	}
	
}
