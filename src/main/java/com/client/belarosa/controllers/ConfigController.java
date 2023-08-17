package com.client.belarosa.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.belarosa.domain.Produto;
import com.client.belarosa.service.DBInitialService;

@RestController
@RequestMapping(value = "/config")
public class ConfigController {
	
	@Autowired
	DBInitialService service;
	
	@GetMapping(value="/start-data-base")
	public ResponseEntity<Produto> instantiateTestDataBase() throws ParseException {
		service.instantiateTestDataBase();
		return ResponseEntity.noContent().build();
	}
}
