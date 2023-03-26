package br.com.controle.acesso.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.acesso.DAO.IRoleDAO;
import br.com.controle.acesso.models.RoleEntity;
import br.com.controle.acesso.services.IRoleService;

@Component
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDAO dao;
	
	@Override
	public RoleEntity salvar(RoleEntity role) {
		return dao.save(role);
	}

	@Override
	public void excluir(RoleEntity role) {
		excluir(role);
	}

	@Override
	public List<RoleEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public RoleEntity getById(Integer id) {
		return dao.getById(id);
	}

}
