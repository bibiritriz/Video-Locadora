package br.gov.sp.itu.fatec.videolocaldora.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String diretor;
  private Integer anoLancamento;
  private boolean disponivel;

  @OneToMany(mappedBy = "filme")
  private List<LocacaoFilme> locacoesFilmes = new ArrayList<>();


  public Long getId() {
    return id;
  }

  public List<LocacaoFilme> getLocacoesFilmes() {
    return locacoesFilmes;
  }

  public void setLocacoesFilmes(List<LocacaoFilme> locacoesFilmes) {
    this.locacoesFilmes = locacoesFilmes;
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

  public Integer getAnoLancamento() {
    return anoLancamento;
  }

  public void setAnoLancamento(Integer anoLancamento) {
    this.anoLancamento = anoLancamento;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  public void setDisponivel(boolean disponibilidade) {
    this.disponivel = disponibilidade;
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
