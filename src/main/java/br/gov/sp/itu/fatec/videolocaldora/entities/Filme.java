package br.gov.sp.itu.fatec.videolocaldora.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_FILMES")
public class Filme implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String diretor;
  private int anoLancamento;
  private boolean disponibilidade;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  public String getDiretor() {
    return diretor;
  }
  public void setDiretor(String diretor) {
    this.diretor = diretor;
  }
  public int getAnoLancamento() {
    return anoLancamento;
  }
  public void setAnoLancamento(int anoLancamento) {
    this.anoLancamento = anoLancamento;
  }
  public boolean isDisponibilidade() {
    return disponibilidade;
  }
  public void setDisponibilidade(boolean disponibilidade) {
    this.disponibilidade = disponibilidade;
  }
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Filme other = (Filme) obj;
    return Objects.equals(id, other.id);
  }
  
  
}
