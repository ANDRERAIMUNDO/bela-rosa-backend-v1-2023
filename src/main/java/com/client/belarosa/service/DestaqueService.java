package com.client.belarosa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.client.belarosa.domain.Destaque;
import com.client.belarosa.repositories.DestaqueRepository;
import com.client.belarosa.service.exception.ObjectNotFoundException;

@Service
public class DestaqueService {

	@Autowired
	DestaqueRepository repository;
	
	public Destaque create (Destaque obj) {
		repository.save(obj);
		return obj;
	}
	
	public Destaque findById (Integer id) {
		Optional<Destaque> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Destaque.class.getName()));
	}
	
	public Page<Destaque> findPage (String nome, Integer page, Integer linesPerPages) {
	    PageRequest pageRequest = PageRequest.of(page, linesPerPages, Sort.by(Sort.Direction.DESC, "id"));
	    return repository.findByFirstNameIgnoreCase (nome, pageRequest);
	}
}
