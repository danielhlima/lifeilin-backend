package br.com.lifeilin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lifeilin.domain.Aluno;
import br.com.lifeilin.repositories.AlunoRepository;
import br.com.lifeilin.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;
	
	public Aluno buscar(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Aluno.class.getName()));
	}
}
