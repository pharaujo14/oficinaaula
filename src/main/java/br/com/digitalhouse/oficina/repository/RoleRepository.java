package br.com.digitalhouse.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digitalhouse.oficina.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
