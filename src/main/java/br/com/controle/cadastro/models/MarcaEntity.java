package br.com.controle.cadastro.models;

import java.io.Serializable;
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
@Table(name = "marca", schema = "estoque")
public class MarcaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private UsuarioEntity usuario;
	private Boolean delete;
	
	public MarcaEntity() {
		usuario = new UsuarioEntity();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marca")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
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
		return Objects.hash(delete, id, nome, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarcaEntity other = (MarcaEntity) obj;
		return Objects.equals(delete, other.delete) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(usuario, other.usuario);
	}
	
	
	
	
	
}
