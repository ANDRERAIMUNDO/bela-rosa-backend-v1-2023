package com.client.belarosa.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.belarosa.domain.Categoria;
import com.client.belarosa.domain.SubCategoria;
import com.client.belarosa.domain.dto.SubCategoriaNewDTO;
import com.client.belarosa.repositories.CategoriaRepository;
import com.client.belarosa.repositories.SubCategoriaRepository;
import com.client.belarosa.service.exception.ObjectNotFoundException;

@Service
public class SubCategoriaService {

	@Autowired
	SubCategoriaRepository repository;
	
	@Autowired
	CategoriaRepository categoria_repository;
	
	@Autowired
	CategoriaService categoria_service;
	
	public SubCategoria create (SubCategoriaNewDTO dto) {
		Categoria categoria = categoria_service.findById(dto.getCategoria_id());
		SubCategoria obj  = new SubCategoria(null, dto.getNome(), categoria);
		categoria.getSub_categorias().addAll(Arrays.asList(obj));
		categoria_repository.save(categoria);
		return repository.save(obj);
	}
	
	public SubCategoria findById (Integer id) {
		Optional<SubCategoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + SubCategoria.class.getName()));
	}
}
