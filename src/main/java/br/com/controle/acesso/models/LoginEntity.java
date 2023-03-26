package br.com.controle.acesso.models;

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

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.controle.cadastro.models.UsuarioEntity;

@EnableJpaRepositories
@Entity
@Table(name = "login", schema = "acesso")
public class LoginEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private UsuarioEntity usuario;
	private String apelido;
	private String password;
	private Boolean delete;
	
	public LoginEntity() {
		usuario = new UsuarioEntity();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_login")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "id_usuario")
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@Column(name = "apelido")
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Column(name = "deletado")
	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apelido, delete, id, password, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginEntity other = (LoginEntity) obj;
		return Objects.equals(apelido, other.apelido) && Objects.equals(delete, other.delete)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(usuario, other.usuario);
	}

	
	



	
	

}
