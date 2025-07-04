package br.gov.sp.itu.fatec.videolocaldora.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.sp.itu.fatec.videolocaldora.entities.Cliente;
import br.gov.sp.itu.fatec.videolocaldora.entities.Locacao;
import br.gov.sp.itu.fatec.videolocaldora.entities.LocacaoFilme;
import br.gov.sp.itu.fatec.videolocaldora.repositories.LocacaoRepository;
import jakarta.transaction.Transactional;

@Service
public class LocacaoService {
  @Autowired
  private LocacaoRepository repository;

  public List<Locacao> getAll() {
    return repository.findAll();
  }

  public Locacao getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Locação não encontrada"));
  }

  public Locacao save(Locacao locacao) {
    return repository.save(locacao);
  }

  public boolean locacaoExist(Long id) {
    return repository.existsById(id);
  }

  @Transactional
  public void update(Locacao locacao) {
    Locacao novoLocacao = repository.getReferenceById(locacao.getId());
    novoLocacao.setCliente(locacao.getCliente());
    novoLocacao.setDataDevolucao(locacao.getDataDevolucao());
    novoLocacao.setDataRetirada(locacao.getDataRetirada());
    novoLocacao.setFilmes(locacao.getFilmes());
    repository.save(novoLocacao);
  }

  public void parcialUpdate(Long id, Map<String, Object> campos) {
    Locacao locacao =
        repository.findById(id).orElseThrow(() -> new RuntimeException("Locação não encontrada"));
    campos.forEach((campo, valor) -> {
      switch (campo) {
        case "cliente":
          locacao.setCliente(((Cliente) valor));
          break;
        case "dataDevolucacao":
          locacao.setDataDevolucao((LocalDate) valor);
          break;
        case "dataRetirada":
          locacao.setDataRetirada((LocalDate) valor);
          break;
        case "filmes":
          locacao.setFilmes(((List<LocacaoFilme>) valor));
          break;
        default:
          throw new RuntimeException("Campo inválido.");
      }
    });
    repository.save(locacao);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
