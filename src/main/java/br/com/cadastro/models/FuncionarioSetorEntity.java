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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario_setor", schema = "cadastro")
public class FuncionarioSetorEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer Id;
	private SetorEntity setor;
	private FuncionarioEntity funcionario;
	private Double salario;
	private Date data;
	
	public FuncionarioSetorEntity() {
		funcionario = new FuncionarioEntity();
		setor = new SetorEntity();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario_setor")
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@OneToOne
	@JoinColumn(name="id_setor")
	public SetorEntity getSetor() {
		return setor;
	}

	public void setSetor(SetorEntity setor) {
		this.setor = setor;
	}

	@OneToOne
	@JoinColumn(name="id_funcionario")
	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioEntity funcionario) {
		this.funcionario = funcionario;
	}

	@Column(name = "salario")
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Column(name = "data")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, data, funcionario, salario, setor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioSetorEntity other = (FuncionarioSetorEntity) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(data, other.data)
				&& Objects.equals(funcionario, other.funcionario) && Objects.equals(salario, other.salario)
				&& Objects.equals(setor, other.setor);
	}
	
	
	
	

}
