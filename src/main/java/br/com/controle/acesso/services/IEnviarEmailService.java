package br.com.controle.acesso.services;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.controle.acesso.models.EnviarEmailEntity;

@Component
public interface IEnviarEmailService {

	public EnviarEmailEntity salvar(EnviarEmailEntity enviarEmail);
	
	public void excluir(EnviarEmailEntity enviarEmail);
	
	public List<EnviarEmailEntity> getAll();
	
	public EnviarEmailEntity getById(Integer id);
	
	public void enviarEmail(EnviarEmailEntity enviarEmail);
	
	public List<EnviarEmailEntity> getAllEmailNaoEnviado();
	
	public void enviaEmailAutomatico();
	
	public void esqueceuSenha(String email);
	
}
