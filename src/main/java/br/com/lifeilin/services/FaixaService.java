package br.com.lifeilin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lifeilin.domain.Faixa;
import br.com.lifeilin.repositories.FaixaRepository;
import br.com.lifeilin.services.exceptions.ObjectNotFoundException;

@Service
public class FaixaService {

	@Autowired
	private FaixaRepository repo;
	
	public Faixa find(Integer id) {
		Optional<Faixa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Faixa.class.getName()));
	}
	
	public Faixa insert(Faixa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Faixa update(Faixa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
