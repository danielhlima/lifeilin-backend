package br.com.lifeilin.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifeilin.domain.Unidade;

@RestController
@RequestMapping(value="/unidades")
public class UnidadeResource {
	
	@GetMapping
	public List<Unidade> listar() {
		
		Unidade uni1 = new Unidade();
		uni1.setId(1);
		uni1.setNome("Matriz");
		Unidade uni2 = new Unidade();
		uni2.setId(2);
		uni2.setNome("Jardim Aricanduva");
		
		List<Unidade> lista = new ArrayList<Unidade>();
		lista.add(uni1);
		lista.add(uni2);
		
		return lista;
	}

}
