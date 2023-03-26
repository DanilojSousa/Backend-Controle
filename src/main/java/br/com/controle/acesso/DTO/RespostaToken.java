package br.com.controle.acesso.DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.controle.acesso.models.LoginEntity;

@JsonTypeName(value = "resposta-token")
public class RespostaToken implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date data;
	private String role;
	private String tempo;
	private String mensagem;
	private String token;
	private Boolean situacao;
	
	public RespostaToken() {

	}
	
	public String getData() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(data);
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Boolean getSituacao() {
		return situacao;
	}
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
	
}
