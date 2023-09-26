package br.com.lifeilin;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.lifeilin.domain.Aluno;
import br.com.lifeilin.domain.Unidade;
import br.com.lifeilin.repositories.AlunoRepository;
import br.com.lifeilin.repositories.UnidadeRepository;

@SpringBootApplication
public class LifeilinApplication implements CommandLineRunner{
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LifeilinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Unidade matriz = new Unidade(null, "Matriz");
		Unidade aricanduva = new Unidade(null, "Aricanduva");
		
		Aluno a1 = new Aluno(null, "Daniel Lima", "danielhenriquelima@gmail.com");
		Aluno a2 = new Aluno(null, "Tita Lima", "titaaplima@gmail.com");
		Aluno a3 = new Aluno(null, "Emely em Paris", "emely@gmail.com");
		Aluno a4 = new Aluno(null, "Irmã Leandro", "irma@gmail.com");
		
		matriz.getAlunos().addAll(Arrays.asList(a1, a2));
		aricanduva.getAlunos().addAll(Arrays.asList(a3, a4));

		a1.setUnidade(matriz);
		a2.setUnidade(matriz);
		a3.setUnidade(aricanduva);
		a4.setUnidade(aricanduva);
		
		unidadeRepository.saveAll(Arrays.asList(matriz, aricanduva));
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4));
	}

}
