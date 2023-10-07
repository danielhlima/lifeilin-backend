package br.com.lifeilin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lifeilin.domain.Tecnica;
import br.com.lifeilin.repositories.TecnicaRepository;
import br.com.lifeilin.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicaService {

	@Autowired
	private TecnicaRepository repo;
	
	public Tecnica buscar(Integer id) {
		Optional<Tecnica> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Tecnica.class.getName()));
	}
	
	public Tecnica insert(Tecnica obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
