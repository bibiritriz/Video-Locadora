package br.gov.sp.itu.fatec.videolocaldora.services;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.sp.itu.fatec.videolocaldora.entities.Filme;
import br.gov.sp.itu.fatec.videolocaldora.entities.Locacao;
import br.gov.sp.itu.fatec.videolocaldora.entities.LocacaoFilme;
import br.gov.sp.itu.fatec.videolocaldora.repositories.LocacaoFilmeRepository;
import jakarta.transaction.Transactional;

@Service
public class LocacaoFilmeService {
  @Autowired
  private LocacaoFilmeRepository repository;

  public List<LocacaoFilme> getAll() {
    return repository.findAll();
  }

  public LocacaoFilme getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Locação não encontrada"));
  }

  public LocacaoFilme save(LocacaoFilme locacaoFilme) {
    return repository.save(locacaoFilme);
  }

  public boolean locacaoFilmeExist(Long id) {
    return repository.existsById(id);
  }

  @Transactional
  public void update(LocacaoFilme locacaoFilme) {
    LocacaoFilme novoLocacaoFilme = repository.getReferenceById(locacaoFilme.getId());

    novoLocacaoFilme.setFilme(locacaoFilme.getFilme());
    novoLocacaoFilme.setLocacao(locacaoFilme.getLocacao());
    novoLocacaoFilme.setQuantidade(locacaoFilme.getQuantidade());
    repository.save(novoLocacaoFilme);
  }

  public void parcialUpdate(Long id, Map<String, Object> campos) {
    LocacaoFilme locacaoFilme =
        repository.findById(id).orElseThrow(() -> new RuntimeException("Locação não encontrada"));
    campos.forEach((campo, valor) -> {
      switch (campo) {
        case "filme":
          locacaoFilme.setFilme(((Filme) valor));
          break;
        case "locacao":
          locacaoFilme.setLocacao((Locacao) valor);
          break;
        case "quantidade":
          locacaoFilme.setQuantidade((Integer) valor);
          break;
        default:
          throw new RuntimeException("Campo inválido.");
      }
    });
    repository.save(locacaoFilme);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
