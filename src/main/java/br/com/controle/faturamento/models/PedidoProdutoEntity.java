package br.com.controle.faturamento.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.controle.cadastro.models.ProdutoEntity;

@Entity
@Table(name="pedido_produto", schema = "faturamento")
public class PedidoProdutoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private PedidoEntity pedido;
	private ProdutoEntity produto;
	private Double valorUnitario;
	private Double valorTotal;
	private Double desconto;
	private Integer qtd;
	private Boolean delete;
	
	public PedidoProdutoEntity() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_produto")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "valor_unitario")
	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Column(name = "valor_total")
	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Column(name = "desconto")
	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	@Column(name = "qtd")
	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	@ManyToOne
	@JoinColumn(name = "id_produto")
	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	@Column(name = "deletado")
	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(delete, desconto, id, pedido, produto, qtd, valorTotal, valorUnitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoProdutoEntity other = (PedidoProdutoEntity) obj;
		return Objects.equals(delete, other.delete) && Objects.equals(desconto, other.desconto)
				&& Objects.equals(id, other.id) && Objects.equals(pedido, other.pedido)
				&& Objects.equals(produto, other.produto) && Objects.equals(qtd, other.qtd)
				&& Objects.equals(valorTotal, other.valorTotal) && Objects.equals(valorUnitario, other.valorUnitario);
	}
	
	
	
	
	
	
}
