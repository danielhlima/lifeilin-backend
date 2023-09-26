package br.com.lifeilin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lifeilin.domain.Unidade;
import br.com.lifeilin.repositories.UnidadeRepository;

@Service
public class UnidadeService {
	
	@Autowired
	private UnidadeRepository repo;

	public Unidade buscar(Integer id) {
		
		Optional<Unidade> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
