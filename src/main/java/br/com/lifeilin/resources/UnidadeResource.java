package br.com.lifeilin.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/unidades")
public class UnidadeResource {
	
	@GetMapping
	public String listar() {
		return "O rest está funcionando";
	}

}
