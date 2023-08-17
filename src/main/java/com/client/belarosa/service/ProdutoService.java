package com.client.belarosa.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.client.belarosa.domain.Categoria;
import com.client.belarosa.domain.Produto;
import com.client.belarosa.domain.SubCategoria;
import com.client.belarosa.domain.dto.ProdutoNewDTO;
import com.client.belarosa.repositories.CategoriaRepository;
import com.client.belarosa.repositories.ProdutoRepository;
import com.client.belarosa.repositories.SubCategoriaRepository;
import com.client.belarosa.service.exception.ObjectNotFoundException;


@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;
	
	@Autowired
	CategoriaRepository categoria_repository;
	
	@Autowired
	SubCategoriaRepository sub_categoria_repository;
	
	@Autowired
	ProdutoRepository produto_repository;
	
	@Autowired
	CategoriaService categoria_service;
	
	@Autowired
	SubCategoriaService sub_categoria_service;
	
	public Produto create (ProdutoNewDTO produto) {
		Categoria categoria = categoria_service.findById(produto.getCategoria_id());
		SubCategoria sub_categoria = sub_categoria_service.findById(produto.getSub_categoria_id());
		Produto obj = new Produto(null, produto.getNome(), produto.getPreco(), produto.getDescricao());
		obj.getCategorias().addAll(Arrays.asList(categoria));
		obj.getSub_categorias().addAll(Arrays.asList(sub_categoria));
		categoria.getProdutos().addAll(Arrays.asList(obj));
		sub_categoria.getProdutos().addAll(Arrays.asList(obj));
		repository.save(obj);
		categoria_repository.save(categoria);
		sub_categoria_repository.save(sub_categoria);
		return obj;
	}
	
	public Produto findById (Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> findPage (String nome, Integer page, Integer linesPerPages) {
	    PageRequest pageRequest = PageRequest.of(page, linesPerPages, Sort.by(Sort.Direction.DESC, "id"));
	    return repository.findByFirstNameIgnoreCase (nome, pageRequest);
	}
}
