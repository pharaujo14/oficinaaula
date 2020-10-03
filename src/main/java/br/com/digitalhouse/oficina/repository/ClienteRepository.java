package br.com.digitalhouse.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digitalhouse.oficina.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
