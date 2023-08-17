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

import com.client.belarosa.domain.Imagem;
import com.client.belarosa.domain.dto.ImagemNewDTO;
import com.client.belarosa.service.ImagemService;

@RestController
@RequestMapping(value = "/imagem")
@CrossOrigin(origins = "https://belarosa.online", maxAge = 3600)
public class ImagemController {
	
	@Autowired
	ImagemService service;
	
	//@PostMapping (value = "/create")
	//public ResponseEntity <ImagemNewDTO> create (@RequestBody ImagemNewDTO obj) { 
	//service.create(obj);
	//return ResponseEntity.ok().body(obj);
	//}
	
	@GetMapping(value="/cod/{id}")
	public ResponseEntity<Imagem> findById(@PathVariable Integer id) {
		Imagem obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
