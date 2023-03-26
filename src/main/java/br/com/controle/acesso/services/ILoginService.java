package br.com.controle.acesso.services;

import java.util.List;

import br.com.controle.acesso.models.LoginEntity;

public interface ILoginService {
	
	public LoginEntity salvar(LoginEntity login);
	
	public void excluir(LoginEntity login);
	
	public List<LoginEntity> getAll();
	
	public List<LoginEntity> getAllAtivos();
	
	public LoginEntity getById(Integer id);

	public LoginEntity entrar(String email, String password);
	
	public LoginEntity getByPorEmail(String email);

}
