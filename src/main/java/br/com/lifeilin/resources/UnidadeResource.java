package br.com.lifeilin.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifeilin.domain.Unidade;
import br.com.lifeilin.services.UnidadeService;

@RestController
@RequestMapping(value="/unidades")
public class UnidadeResource {
	
	
	@Autowired
	private UnidadeService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Unidade obj = service.buscar(id);
		return ResponseEntity.ok().body(obj); 
	}

}
