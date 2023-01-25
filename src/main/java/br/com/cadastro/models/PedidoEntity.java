package br.com.cadastro.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido", schema = "faturamento")
public class PedidoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer pedCodigo;
	private TipoPedidoEntity tipoPedido;
	private String dadosAdicionais;
	private Integer pedValorTotal;
	private FormaPagamentoEntity formaPagamento;
	private Date pedEmissao;
	private SituacaoPedidoEntity situacao;
	
	public PedidoEntity() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	public Integer getPedCodigo() {
		return pedCodigo;
	}

	public void setPedCodigo(Integer pedCodigo) {
		this.pedCodigo = pedCodigo;
	}

	@ManyToOne
	@JoinColumn(name = "id_tipo_pedido")
	public TipoPedidoEntity getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedidoEntity tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	@Column(name = "dados_adicionais")
	public String getDadosAdicionais() {
		return dadosAdicionais;
	}

	public void setDadosAdicionais(String dadosAdicionais) {
		this.dadosAdicionais = dadosAdicionais;
	}

	@Column(name = "valor_total")
	public Integer getPedValorTotal() {
		return pedValorTotal;
	}

	public void setPedValorTotal(Integer pedValorTotal) {
		this.pedValorTotal = pedValorTotal;
	}

	@ManyToOne
	@JoinColumn(name = "id_pagamento")
	public FormaPagamentoEntity getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoEntity formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Column(name = "emissao")
	public Date getPedEmissao() {
		return pedEmissao;
	}

	public void setPedEmissao(Date pedEmissao) {
		this.pedEmissao = pedEmissao;
	}

	@ManyToOne
	@JoinColumn(name = "id_situacao_pedido")
	public SituacaoPedidoEntity getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedidoEntity situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dadosAdicionais, formaPagamento, pedCodigo, pedEmissao, pedValorTotal, situacao,
				tipoPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoEntity other = (PedidoEntity) obj;
		return Objects.equals(dadosAdicionais, other.dadosAdicionais)
				&& Objects.equals(formaPagamento, other.formaPagamento) && Objects.equals(pedCodigo, other.pedCodigo)
				&& Objects.equals(pedEmissao, other.pedEmissao) && Objects.equals(pedValorTotal, other.pedValorTotal)
				&& Objects.equals(situacao, other.situacao) && Objects.equals(tipoPedido, other.tipoPedido);
	}
	
	
	
	
	

}
