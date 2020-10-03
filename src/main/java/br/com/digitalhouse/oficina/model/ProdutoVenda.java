package br.com.digitalhouse.oficina.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produtos_vendas")
public class ProdutoVenda {
	
	@EmbeddedId
	private ProdutoVendaKey id = new ProdutoVendaKey();
	
	@ManyToOne
	@MapsId("vendaId")
	@JoinColumn(name="venda_id")
	@JsonIgnore
	private Venda venda;
	
	@ManyToOne
	@MapsId("produtoId")
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	private int quantidade;
	
	private double precoEfetivo;

	public ProdutoVenda() {
	}

	public ProdutoVenda(Venda venda, Produto produto, int quantidade, double precoEfetivo) {
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoEfetivo = precoEfetivo;
	}

	public ProdutoVendaKey getId() {
		return id;
	}

	public void setId(ProdutoVendaKey id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoEfetivo() {
		return precoEfetivo;
	}

	public void setPrecoEfetivo(double precoEfetivo) {
		this.precoEfetivo = precoEfetivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoVenda other = (ProdutoVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
