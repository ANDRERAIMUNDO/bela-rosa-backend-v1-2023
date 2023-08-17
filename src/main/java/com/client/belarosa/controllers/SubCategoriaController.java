package com.client.belarosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.belarosa.domain.SubCategoria;
import com.client.belarosa.domain.dto.SubCategoriaNewDTO;
import com.client.belarosa.service.SubCategoriaService;

@RestController
@RequestMapping(value = "/sub-categoria")
@CrossOrigin(origins = "https://belarosa.online", maxAge = 3600)
public class SubCategoriaController {
	
	@Autowired
	SubCategoriaService service;
	
	//@PostMapping (value = "/create")
	//public ResponseEntity <SubCategoriaNewDTO> create (@RequestBody SubCategoriaNewDTO obj) { 
	//service.create(obj);
	//return ResponseEntity.ok().body(obj);
	//}
	
	@GetMapping(value="/cod/{id}")
	public ResponseEntity<SubCategoria> findById(@PathVariable Integer id) {
		SubCategoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
