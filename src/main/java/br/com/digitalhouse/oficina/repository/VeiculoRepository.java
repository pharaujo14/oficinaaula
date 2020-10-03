package br.com.digitalhouse.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.oficina.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	@Query(value= "select * from veiculos where cor = :cor", nativeQuery=true)
	List<Veiculo> findAllByCor(String cor);

}
