package br.gov.sp.itu.fatec.videolocaldora.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.gov.sp.itu.fatec.videolocaldora.entities.Locacao;
import br.gov.sp.itu.fatec.videolocaldora.services.LocacaoService;

@RestController
@CrossOrigin
public class LocacaoController {
  @Autowired
  private LocacaoService service;

  @GetMapping("locacoes")
  public ResponseEntity<List<Locacao>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("locacao/{id}")
  public ResponseEntity<Locacao> getById(@PathVariable Long id) {
    if (!service.locacaoExist(id)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(service.getById(id));
  }

  @PostMapping("locacoes")
  public ResponseEntity<Locacao> save(@RequestBody Locacao locacao) {
    Locacao savedLocacao = service.save(locacao);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/locacao/{id}")
        .buildAndExpand(savedLocacao.getId()).toUri();

    return ResponseEntity.created(location).body(savedLocacao);
  }

  @PutMapping("locacao/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Locacao locacao) {
    if (!service.locacaoExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.update(locacao);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("locacao/{id}")
  public ResponseEntity<Void> parcialUpdate(@PathVariable Long id,
      @RequestBody Map<String, Object> campos) {
    if (!service.locacaoExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.parcialUpdate(id, campos);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("locacao/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!service.locacaoExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
