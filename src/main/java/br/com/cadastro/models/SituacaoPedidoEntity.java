package br.com.cadastro.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "situacao_Pedido", schema = "faturamento")
public class SituacaoPedidoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	
	public SituacaoPedidoEntity() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_situacao_pedido")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SituacaoPedidoEntity other = (SituacaoPedidoEntity) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}

	

	
	
	
}
