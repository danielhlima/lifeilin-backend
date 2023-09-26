package br.com.lifeilin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lifeilin.domain.Faixa;

@Repository
public interface FaixaRepository extends JpaRepository<Faixa, Integer> {

}
