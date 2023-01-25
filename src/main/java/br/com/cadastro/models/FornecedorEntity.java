package br.com.cadastro.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "fornecedor", schema = "cadastro")
public class FornecedorEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private RegistroEntity registro;
	private String cnpj;
			
	public FornecedorEntity() {
		registro = new RegistroEntity();		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="registro")
	public RegistroEntity getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroEntity registro) {
		this.registro = registro;
	}

	@NotBlank
	@Column(name = "cnpj")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, id, registro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorEntity other = (FornecedorEntity) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id)
				&& Objects.equals(registro, other.registro);
	}


}
