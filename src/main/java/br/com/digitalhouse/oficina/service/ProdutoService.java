package br.com.digitalhouse.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.model.Produto;
import br.com.digitalhouse.oficina.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	
	public Produto create(Produto produto) {
		produto.setId(null);
		return this.produtoRepository.save(produto);
	}
	
	public Produto update(Produto novo) {

		return this.produtoRepository.save(novo);
		
	}
	 
	
	public Produto findById(Long id) {
		Optional
			.ofNullable(id)
			.orElseThrow( () -> new RuntimeException("O id não pode ser nulo"));  // todo: criar exceção personalizada para argumento ilegal
		
		return this.produtoRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("Não foi possivel encontrar um objeto com id " + id)); // todo: mudar pra object not found exception
	}
	
	public List<Produto> findAll(){
		return this.produtoRepository.findAll();
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		
		this.produtoRepository.deleteById(id);
	}
	
}

