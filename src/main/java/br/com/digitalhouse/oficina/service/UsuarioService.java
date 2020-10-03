package br.com.digitalhouse.oficina.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.model.Role;
import br.com.digitalhouse.oficina.model.Usuario;
import br.com.digitalhouse.oficina.repository.RoleRepository;
import br.com.digitalhouse.oficina.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
		this.usuarioRepository = usuarioRepository;
		this.roleRepository = roleRepository;
	}

	
	@Transactional
	public Usuario create(Usuario usuario) {
		
		usuario.getRoles().stream()
		  .filter( r -> r.getId() == null)
		  .forEach(r -> {
			  r = this.roleRepository.save(r);
		  });
		
		return this.usuarioRepository.save(usuario);
	
	}
	
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
	
	
	public List<Role> findAllRole(){
		return this.roleRepository.findAll();
	}
	
}
