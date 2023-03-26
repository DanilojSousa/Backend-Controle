package br.com.controle.faturamento.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="servico", schema = "faturamento")
@SequenceGenerator(name = "SERVICO_GENERATOR", sequenceName = "SEQ_SERVICO", allocationSize = 1)
public class ServicoEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	
	public ServicoEntity() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SERVICO_GENERATOR")
	@Column(name="id_servico")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="descricao")
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
		ServicoEntity other = (ServicoEntity) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}


	
}
