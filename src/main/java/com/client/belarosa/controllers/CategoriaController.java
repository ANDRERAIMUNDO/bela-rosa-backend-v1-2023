package com.client.belarosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.belarosa.domain.Categoria;
import com.client.belarosa.domain.dto.ListCategoriaDTO;
import com.client.belarosa.service.CategoriaService;
import com.client.belarosa.ultis.URL;

@RestController
@RequestMapping(value = "/categoria")
@CrossOrigin(origins = "https://belarosa.online", maxAge = 3600)
public class CategoriaController {
	
	@Autowired
	CategoriaService service;
	
	//@PostMapping (value = "/create")
	//public ResponseEntity <Categoria> create (@RequestBody Categoria obj) { 
	//service.create(obj);
	//return ResponseEntity.ok().body(obj);
	//}
	
	@GetMapping(value="/cod/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping (value = "/list")
	public ResponseEntity<Page<ListCategoriaDTO>> findPage(
			@RequestParam(value="nome", defaultValue = "")String nome,
			@RequestParam(value="page", defaultValue = "0")Integer page,
			@RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages) {
		String nomeDecoded = URL.decodeParam(nome);
		Page <Categoria> list = service.findPage(nomeDecoded, page, linesPerPages);
		Page<ListCategoriaDTO>listDto = list.map(obj -> new ListCategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	} 
}
