package br.com.digitalhouse.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.model.Veiculo;
import br.com.digitalhouse.oficina.repository.OrdemServicoRepository;
import br.com.digitalhouse.oficina.repository.VeiculoRepository;

@Service
public class OrdemServicoService {

	private final OrdemServicoRepository ordemServicoRepository;

	@Autowired
	public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
		this.ordemServicoRepository = ordemServicoRepository;
	}

	public OrdemServico create(OrdemServico ordemServico) {
		ordemServico.setId(null);
		return this.ordemServicoRepository.save(ordemServico);
	}

	public OrdemServico update(OrdemServico novo) {

		OrdemServico antiga = this.findById(novo.getId());

		antiga.setCliente(novo.getCliente());
		antiga.setVeiculo(novo.getVeiculo());
		antiga.setDescricao(novo.getDescricao());
		antiga.setValor(novo.getValor());

		return this.ordemServicoRepository.save(antiga);

	}

	public OrdemServico findById(Long id) {
		Optional.ofNullable(id).orElseThrow(() -> new RuntimeException("O id não pode ser nulo")); 

		return this.ordemServicoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi possivel encontrar um objeto com id " + id));
	}

	public List<OrdemServico> findAll() {
		return this.ordemServicoRepository.findAll();
	}

	public void deleteById(Long id) {
		this.findById(id);

		this.ordemServicoRepository.deleteById(id);
	}

}