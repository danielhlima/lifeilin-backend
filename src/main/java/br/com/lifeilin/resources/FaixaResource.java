package br.com.lifeilin.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifeilin.domain.Faixa;
import br.com.lifeilin.services.FaixaService;

@RestController
@RequestMapping(value="/faixas")
public class FaixaResource {
	
	
	@Autowired
	private FaixaService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Faixa obj = service.buscar(id);
		return ResponseEntity.ok().body(obj); 
	}

}
