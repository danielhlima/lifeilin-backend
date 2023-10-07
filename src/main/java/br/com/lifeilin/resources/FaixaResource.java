package br.com.lifeilin.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.lifeilin.domain.Faixa;
import br.com.lifeilin.services.FaixaService;

@RestController
@RequestMapping(value="/faixas")
public class FaixaResource {
	
	
	@Autowired
	private FaixaService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Faixa> find(@PathVariable Integer id) {
		Faixa obj = service.find(id);
		return ResponseEntity.ok().body(obj); 
	}

	@PostMapping
	public ResponseEntity<Void> insert (@RequestBody Faixa obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody Faixa obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.noContent().build();
	}
}
