package br.com.lifeilin;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.lifeilin.domain.Aluno;
import br.com.lifeilin.domain.Faixa;
import br.com.lifeilin.domain.Tecnica;
import br.com.lifeilin.domain.Unidade;
import br.com.lifeilin.repositories.AlunoRepository;
import br.com.lifeilin.repositories.FaixaRepository;
import br.com.lifeilin.repositories.TecnicaRepository;
import br.com.lifeilin.repositories.UnidadeRepository;

@SpringBootApplication
public class LifeilinApplication implements CommandLineRunner{
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private FaixaRepository faixaRepository;
	
	@Autowired
	private TecnicaRepository tecnicaRepository;

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
		
		Faixa branca = new Faixa(null, "Branca");
		Faixa amarela = new Faixa(null, "Amarela");
		
		Tecnica jibenbaxi = new Tecnica(null, "Ji Ben Ba Xi");
		Tecnica xiaosishou = new Tecnica(null, "Xiao si Shou");
		
		branca.getTecnicas().addAll(Arrays.asList(jibenbaxi));
		amarela.getTecnicas().addAll(Arrays.asList(xiaosishou));
		
		jibenbaxi.setFaixa(branca);
		xiaosishou.setFaixa(amarela);
		
		faixaRepository.saveAll(Arrays.asList(branca, amarela));
		tecnicaRepository.saveAll(Arrays.asList(jibenbaxi, xiaosishou));
		
		a1.setFaixa(branca);
		a2.setFaixa(amarela);
		a3.setFaixa(branca);
		a4.setFaixa(amarela);
		
		unidadeRepository.saveAll(Arrays.asList(matriz, aricanduva));
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4));
	}

}
