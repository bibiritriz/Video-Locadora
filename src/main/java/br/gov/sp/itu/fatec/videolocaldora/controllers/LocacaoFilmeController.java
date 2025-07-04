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
import br.gov.sp.itu.fatec.videolocaldora.entities.LocacaoFilme;
import br.gov.sp.itu.fatec.videolocaldora.services.LocacaoFilmeService;

@RestController
@CrossOrigin
public class LocacaoFilmeController {
  @Autowired
  private LocacaoFilmeService service;

  @GetMapping("locacoesfilme")
  public ResponseEntity<List<LocacaoFilme>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("locacaofilme/{id}")
  public ResponseEntity<LocacaoFilme> getById(@PathVariable Long id) {
    if (!service.locacaoFilmeExist(id)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(service.getById(id));
  }

  @PostMapping("locacoesfilme")
  public ResponseEntity<LocacaoFilme> save(@RequestBody LocacaoFilme locacaofilme) {
    LocacaoFilme savedLocacaoFilme = service.save(locacaofilme);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/locacaofilme/{id}")
        .buildAndExpand(savedLocacaoFilme.getId()).toUri();

    return ResponseEntity.created(location).body(savedLocacaoFilme);
  }

  @PutMapping("locacaofilme/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id,
      @RequestBody LocacaoFilme locacaoFilme) {
    if (!service.locacaoFilmeExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.update(locacaoFilme);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("locacaofilme/{id}")
  public ResponseEntity<Void> parcialUpdate(@PathVariable Long id,
      @RequestBody Map<String, Object> campos) {
    if (!service.locacaoFilmeExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.parcialUpdate(id, campos);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("locacaofilme/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!service.locacaoFilmeExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
