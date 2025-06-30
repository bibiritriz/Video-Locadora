package br.gov.sp.itu.fatec.videolocaldora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.itu.fatec.videolocaldora.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
  
}
