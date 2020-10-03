package br.com.digitalhouse.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digitalhouse.oficina.model.ProdutoVenda;
import br.com.digitalhouse.oficina.model.ProdutoVendaKey;

public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, ProdutoVendaKey>{

}
