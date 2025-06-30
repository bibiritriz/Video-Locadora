package br.gov.sp.itu.fatec.videolocaldora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.itu.fatec.videolocaldora.entities.LocacaoFilme;

public interface LocacaoFilmeRepository extends JpaRepository<LocacaoFilme, Long>{
  
}
