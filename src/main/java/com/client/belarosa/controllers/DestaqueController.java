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

import com.client.belarosa.domain.Destaque;
import com.client.belarosa.service.DestaqueService;
import com.client.belarosa.ultis.URL;

@RestController
@RequestMapping(value = "/destaque")
@CrossOrigin(origins = "https://belarosa.online", maxAge = 3600)
public class DestaqueController {
	
	@Autowired
	DestaqueService service;
	
	//@PostMapping (value = "/create")
	//public ResponseEntity <Destaque> create (@RequestBody Destaque obj) { 
	//service.create(obj);
	//return ResponseEntity.ok().body(obj);
	//}
	
	@GetMapping(value="/cod/{id}")
	public ResponseEntity<Destaque> findById(@PathVariable Integer id) {
		Destaque obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping (value = "/page")
	public ResponseEntity<Page<Destaque>> findPage(
			@RequestParam(value="nome", defaultValue = "")String nome,
			@RequestParam(value="page", defaultValue = "0")Integer page,
			@RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages) {
		String nomeDecoded = URL.decodeParam(nome);
		Page <Destaque> list = service.findPage(nomeDecoded, page, linesPerPages);
		return ResponseEntity.ok().body(list);
	} 
}
