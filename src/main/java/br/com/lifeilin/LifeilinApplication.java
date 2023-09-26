package br.com.lifeilin;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.lifeilin.domain.Unidade;
import br.com.lifeilin.repositories.UnidadeRepository;

@SpringBootApplication
public class LifeilinApplication implements CommandLineRunner{
	
	@Autowired
	private UnidadeRepository unidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(LifeilinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Unidade matriz = new Unidade(null, "Matriz");
		Unidade aricanduva = new Unidade(null, "Aricanduva");
		
		unidadeRepository.saveAll(Arrays.asList(matriz, aricanduva));
	}

}
