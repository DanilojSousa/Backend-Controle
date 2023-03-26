package br.com.controle.cadastro.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ncm", schema = "fiscal")
public class NcmEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numeroNcm;
	
	public NcmEntity() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ncm")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "ncm")
	public String getNumeroNcm() {
		return numeroNcm;
	}

	public void setNumeroNcm(String numeroNcm) {
		this.numeroNcm = numeroNcm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numeroNcm);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NcmEntity other = (NcmEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(numeroNcm, other.numeroNcm);
	}

	
	

	

}
