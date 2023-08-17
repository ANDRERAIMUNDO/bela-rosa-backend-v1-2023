package com.client.belarosa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.client.belarosa.domain.Categoria;
import com.client.belarosa.domain.Produto;
import com.client.belarosa.repositories.CategoriaRepository;
import com.client.belarosa.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;
	
	public Categoria create (Categoria obj) {
		return repository.save(obj);
	}
	
	public Categoria findById (Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Page<Categoria> findPage (String nome, Integer page, Integer linesPerPages) {
	    PageRequest pageRequest = PageRequest.of(page, linesPerPages, Sort.by(Sort.Direction.ASC, "id"));
	    return repository.findByFirstNameIgnoreCase (nome, pageRequest);
	}
}
