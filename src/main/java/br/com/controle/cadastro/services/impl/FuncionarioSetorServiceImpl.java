package br.com.controle.cadastro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.cadastro.DAO.IFuncionarioSetorDAO;
import br.com.controle.cadastro.models.FuncionarioSetorEntity;
import br.com.controle.cadastro.services.IFuncionarioSetorService;

@Component
public class FuncionarioSetorServiceImpl  implements IFuncionarioSetorService {
	
	@Autowired
	private IFuncionarioSetorDAO dao;

	@Override
	public FuncionarioSetorEntity salvar(FuncionarioSetorEntity funcionarioSetor) {
		return dao.save(funcionarioSetor);
	}

	@Override
	public List<FuncionarioSetorEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public List<FuncionarioSetorEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@Override
	public void excluir(FuncionarioSetorEntity funcionarioSetor) {
		dao.delete(funcionarioSetor);
	}

	@Override
	public FuncionarioSetorEntity getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public Boolean possueFuncionario(Integer id) {
		if(dao.getByIdPorFuncionario(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean possueFuncao(Integer id) {
		if(dao.getByIdPorFuncao(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean possueNivel(Integer id) {
		if(dao.getByIdPorNivel(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
}
