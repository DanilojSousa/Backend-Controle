package br.com.cadastro.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tipo_pedido", schema = "faturamento")
@SequenceGenerator(name = "SERVICO_GENERATOR", sequenceName = "SEQ_SERVICO", allocationSize = 1)
public class TipoPedidoEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Boolean destacaImpostos;
	private Boolean geraEstoque;
	private Boolean geraDuplicata;
	private ServicoEntity servico;
	
	public TipoPedidoEntity() {
		servico = new ServicoEntity();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SERVICO_GENERATOR")
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="descricao")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="destaca_impostos", nullable = false, columnDefinition = "BOOLEAN")
	public Boolean getDestacaImpostos() {
		return destacaImpostos;
	}

	public void setDestacaImpostos(Boolean destacaImpostos) {
		this.destacaImpostos = destacaImpostos;
	}

	@Column(name="gera_estoque", nullable = false, columnDefinition = "BOOLEAN")
	public Boolean getGeraEstoque() {
		return geraEstoque;
	}

	public void setGeraEstoque(Boolean geraEstoque) {
		this.geraEstoque = geraEstoque;
	}

	@Column(name="gera_duplicata", nullable = false, columnDefinition = "BOOLEAN")
	public Boolean getGeraDuplicata() {
		return geraDuplicata;
	}

	public void setGeraDuplicata(Boolean geraDuplicata) {
		this.geraDuplicata = geraDuplicata;
	}
	
	@ManyToOne
	@JoinColumn(name="id_servico")
	public ServicoEntity getServico() {
		return servico;
	}

	public void setServico(ServicoEntity servico) {
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destacaImpostos, geraDuplicata, geraEstoque, id, nome, servico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPedidoEntity other = (TipoPedidoEntity) obj;
		return Objects.equals(destacaImpostos, other.destacaImpostos)
				&& Objects.equals(geraDuplicata, other.geraDuplicata) && Objects.equals(geraEstoque, other.geraEstoque)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(servico, other.servico);
	}



	
	
	
	
}
