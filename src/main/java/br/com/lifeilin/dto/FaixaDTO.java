package br.com.lifeilin.dto;

import java.io.Serializable;

import br.com.lifeilin.domain.Faixa;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class FaixaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=4, max=30, message="O tamanho deste campo deve estar entre 5 e 30 caractéres.")
	private String nome;
	
	public FaixaDTO() {}
	
	public FaixaDTO(Faixa faixa) {
		this.id = faixa.getId();
		this.nome = faixa.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
