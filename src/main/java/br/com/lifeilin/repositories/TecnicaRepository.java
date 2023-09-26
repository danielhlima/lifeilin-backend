package br.com.lifeilin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lifeilin.domain.Tecnica;

@Repository
public interface TecnicaRepository extends JpaRepository<Tecnica, Integer> {

}
