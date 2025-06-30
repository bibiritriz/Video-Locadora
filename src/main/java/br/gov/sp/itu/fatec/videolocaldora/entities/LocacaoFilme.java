package br.gov.sp.itu.fatec.videolocaldora.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_LOCACAOFILME")
public class LocacaoFilme implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "locacao_id")
  private Locacao locacao;


  @ManyToOne
  @JoinColumn(name = "filme_id")
  private Filme filme;

  private int quantidade;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Locacao getLocacao() {
    return locacao;
  }

  public void setLocacao(Locacao locacao) {
    this.locacao = locacao;
  }

  public Filme getFilme() {
    return filme;
  }

  public void setFilme(Filme filme) {
    this.filme = filme;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
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
    LocacaoFilme other = (LocacaoFilme) obj;
    return Objects.equals(id, other.id);
  }


}
