package br.gov.sp.itu.fatec.videolocaldora.services;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.sp.itu.fatec.videolocaldora.entities.Cliente;
import br.gov.sp.itu.fatec.videolocaldora.repositories.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
  @Autowired
  private ClienteRepository repository;

  public List<Cliente> getAll() {
    return repository.findAll();
  }

  public Cliente getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
  }

  public Cliente save(Cliente cliente) {
    return repository.save(cliente);
  }

  public boolean clienteExist(Long id) {
    return repository.existsById(id);
  }

  @Transactional
  public void update(Cliente cliente) {
    Cliente novoCliente = repository.getReferenceById(cliente.getId());
    novoCliente.setEmail(cliente.getEmail());
    novoCliente.setNome(cliente.getNome());
    novoCliente.setTelefone(cliente.getTelefone());
    repository.save(novoCliente);
  }

  public void parcialUpdate(Long id, Map<String, Object> campos) {
    Cliente cliente =
        repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    campos.forEach((campo, valor) -> {
      switch (campo) {
        case "email":
          cliente.setEmail((String) valor);
          break;
        case "nome":
          cliente.setNome((String) valor);
          break;
        case "telefone":
          cliente.setTelefone((String) valor);
          break;
        default:
          throw new RuntimeException("Campo inválido.");
      }
    });
    repository.save(cliente);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }


}
