package br.com.controle.acesso.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enviar_email", schema = "geral")
public class EnviarEmailEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String destinatario;
	private String assunto;
	private String conteudo;
	private Boolean enviado;
	private String status;
	
	public EnviarEmailEntity() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_enviar_email")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "destinatario")
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	@Column(name = "assunto")
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	@Column(name = "conteudo")
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	@Column(name = "enviado")
	public Boolean getEnviado() {
		return enviado;
	}
	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assunto, conteudo, destinatario, enviado, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnviarEmailEntity other = (EnviarEmailEntity) obj;
		return Objects.equals(assunto, other.assunto) && Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(destinatario, other.destinatario) && Objects.equals(enviado, other.enviado)
				&& Objects.equals(id, other.id) && Objects.equals(status, other.status);
	}

	

}
