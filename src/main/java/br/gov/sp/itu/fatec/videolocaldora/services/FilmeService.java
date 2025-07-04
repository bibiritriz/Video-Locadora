package br.gov.sp.itu.fatec.videolocaldora.services;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.gov.sp.itu.fatec.videolocaldora.entities.Filme;
import br.gov.sp.itu.fatec.videolocaldora.entities.LocacaoFilme;
import br.gov.sp.itu.fatec.videolocaldora.repositories.FilmeRepository;

@Service
public class FilmeService {
  @Autowired
  private FilmeRepository repository;

  public List<Filme> getAll() {
    return repository.findAll();
  }

  public Filme save(Filme filme) {
    return repository.save(filme);
  }

  public Filme getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado."));
  }

  public boolean filmExist(Long id) {
    return repository.existsById(id);
  }

  @Transactional
  public void update(Filme filme) {
    Filme novoFilme = repository.getReferenceById(filme.getId());
    novoFilme.setTitulo(filme.getTitulo());
    novoFilme.setDisponivel(filme.isDisponivel());
    novoFilme.setDiretor(filme.getDiretor());
    novoFilme.setAnoLancamento(filme.getAnoLancamento());
    
    repository.save(novoFilme);
  }

  public void parcialUpdate(Long id, Map<String, Object> campos) {
    Filme filmeExistente =
        repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado."));

    campos.forEach((campo, valor) -> {
      switch (campo) {
        case "titulo":
          filmeExistente.setTitulo((String) valor);
          break;
        case "disponibilidade":
          filmeExistente.setDisponivel((Boolean) valor);
          break;
        case "diretor":
          filmeExistente.setDiretor((String) valor);
          break;
        case "anoLancamento":
          filmeExistente.setAnoLancamento((Integer) valor);
          break;
        case "locacao":
          filmeExistente.setLocacoesFilmes((List<LocacaoFilme>) valor);
        default:
          throw new RuntimeException("Campo inválido.");
      }
    });
    repository.save(filmeExistente);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
