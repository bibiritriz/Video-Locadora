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
import br.gov.sp.itu.fatec.videolocaldora.entities.Cliente;
import br.gov.sp.itu.fatec.videolocaldora.services.ClienteService;

@RestController
@CrossOrigin
public class ClienteController {
  @Autowired
  private ClienteService service;

  @GetMapping("clientes")
  public ResponseEntity<List<Cliente>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("cliente/{id}")
  public ResponseEntity<Cliente> getById(@PathVariable Long id) {
    if (!service.clienteExist(id)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(service.getById(id));
  }

  @PostMapping("clientes")
  public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
    Cliente savedCliente = service.save(cliente);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/cliente/{id}")
        .buildAndExpand(savedCliente.getId()).toUri();

    return ResponseEntity.created(location).body(savedCliente);
  }

  @PutMapping("cliente/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Cliente cliente) {
    if (!service.clienteExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.update(cliente);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("cliente/{id}")
  public ResponseEntity<Void> parcialUpdate(@PathVariable Long id,
      @RequestBody Map<String, Object> campos) {
    if (!service.clienteExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.parcialUpdate(id, campos);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("cliente/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!service.clienteExist(id)) {
      return ResponseEntity.notFound().build();
    }
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
