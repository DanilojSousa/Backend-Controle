package br.com.controle.acesso.services;

import java.util.List;

import br.com.controle.acesso.models.RoleEntity;

public interface IRoleService {

	public RoleEntity salvar(RoleEntity role);
	
	public void excluir(RoleEntity role);
	
	public List<RoleEntity> getAll();
	
	public RoleEntity getById(Integer id);
}
