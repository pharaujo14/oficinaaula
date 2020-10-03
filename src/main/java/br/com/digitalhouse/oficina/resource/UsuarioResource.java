package br.com.digitalhouse.oficina.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digitalhouse.oficina.model.Role;
import br.com.digitalhouse.oficina.model.Usuario;
import br.com.digitalhouse.oficina.service.UsuarioService;

@RestController
public class UsuarioResource {
	
	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioResource(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
	
	@PostMapping("/usuarios")
	public ResponseEntity<Void> create( @RequestBody Usuario usuario){
		
		usuario = this.usuarioService.create(usuario);
		
		URI uri = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(usuario.getId())
				 .toUri();
		
		
		return ResponseEntity.created(uri).build();
		
	}
	
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> findAllUsuarios(){
		return ResponseEntity.ok(this.usuarioService.findAll());
	}
	
	@GetMapping("/role")
	public ResponseEntity<List<Role>> findAllRoles(){
		return ResponseEntity.ok(this.usuarioService.findAllRole());
	}
	
	
}
