package br.gov.sp.itu.fatec.videolocaldora.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.gov.sp.itu.fatec.videolocaldora.entities.Filme;
import br.gov.sp.itu.fatec.videolocaldora.services.FilmeService;



@RestController
@CrossOrigin
public class FilmeController {
  @Autowired
  private FilmeService service;

  @GetMapping("filmes")
  public ResponseEntity<List<Filme>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("filme/{id}")
  public ResponseEntity<Filme> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getById(id));
  }

  @PostMapping("filmes")
  public ResponseEntity<Filme> save(@RequestBody Filme filme) {
    Filme savedFilme = service.save(filme);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/filme/{id}")
        .buildAndExpand(savedFilme.getId()).toUri();

    return ResponseEntity.created(location).body(savedFilme);
  }

}
