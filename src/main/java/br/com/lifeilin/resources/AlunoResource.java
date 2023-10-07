package br.com.lifeilin.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifeilin.domain.Aluno;
import br.com.lifeilin.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<Aluno>find(@PathVariable Integer id){
		
		Aluno obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
