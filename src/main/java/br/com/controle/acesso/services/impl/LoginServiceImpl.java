package br.com.controle.acesso.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.acesso.DAO.ILoginDAO;
import br.com.controle.acesso.models.LoginEntity;
import br.com.controle.acesso.services.ILoginService;

@Component
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private ILoginDAO dao;

	@Override
	public LoginEntity salvar(LoginEntity login) {
		return dao.save(login);
	}

	@Override
	public void excluir(LoginEntity login) {
		dao.delete(login);
	}

	@Override
	public List<LoginEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public List<LoginEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}

	@Override
	public LoginEntity getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public LoginEntity entrar(String email, String password) {
		return dao.entrar(email, password);
	}

	@Override
	public LoginEntity getByPorEmail(String email) {
		return dao.getByPorEmail(email);
	}

}
