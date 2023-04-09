package br.com.controle.acesso.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "roles", schema = "acesso")
public class RoleEntity implements GrantedAuthority, Serializable {

		private static final long serialVersionUID = 1L;
		
		private Integer id;
		private String nome;
		
		public RoleEntity() {}
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_role")
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		@Column(name="nome")
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		@Transient 
		public String getAuthority() {
			return this.nome;
		}


		public String setAuthority(String nome) {
			return this.nome = nome;
		}
		
		
		@Override
		public int hashCode() {
			return Objects.hash(id, nome);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RoleEntity other = (RoleEntity) obj;
			return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
		}


		



		
		

	}

