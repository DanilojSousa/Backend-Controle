package br.com.cadastro.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cliente", schema = "cadastro")
public class ClienteEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private RegistroEntity registro;
	private String cpf;
	private Date nascimento;
				
	public ClienteEntity() {
		registro = new RegistroEntity();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(name= "cpf", length = 11)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "nascimento", length = 20)
	public Date getNascimento() {			
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@Column(name ="registro")
	public RegistroEntity getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroEntity registro) {
		this.registro = registro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id, nascimento, registro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id)
				&& Objects.equals(nascimento, other.nascimento) && Objects.equals(registro, other.registro);
	}
	
	

	
}
