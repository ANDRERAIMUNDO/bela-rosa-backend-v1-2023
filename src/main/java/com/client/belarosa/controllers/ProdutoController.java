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

import com.client.belarosa.domain.Produto;
import com.client.belarosa.domain.dto.PageProdutoDTO;
import com.client.belarosa.domain.dto.ProdutoNewDTO;
import com.client.belarosa.service.ProdutoService;
import com.client.belarosa.ultis.URL;

@RestController
@RequestMapping(value = "/produto")
@CrossOrigin(origins = "https://belarosa.online", maxAge = 3600)
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	//@PostMapping (value = "/create")
	//public ResponseEntity <ProdutoNewDTO> create (@RequestBody ProdutoNewDTO obj) { 
	//service.create(obj);
	//return ResponseEntity.ok().body(obj);
	//}
	
	@GetMapping(value="/cod/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping (value = "/page")
	public ResponseEntity<Page<PageProdutoDTO>> findPage(
			@RequestParam(value="nome", defaultValue = "")String nome,
			@RequestParam(value="page", defaultValue = "0")Integer page,
			@RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages) {
		String nomeDecoded = URL.decodeParam(nome);
		Page <Produto> list = service.findPage(nomeDecoded, page, linesPerPages);
		Page<PageProdutoDTO>listDto = list.map(obj -> new PageProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	} 
}
