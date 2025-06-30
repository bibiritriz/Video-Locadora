package br.gov.sp.itu.fatec.videolocaldora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.itu.fatec.videolocaldora.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
  
}
