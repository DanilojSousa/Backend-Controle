package br.com.controle.cadastro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.cadastro.DAO.ISetorDAO;
import br.com.controle.cadastro.models.SetorEntity;
import br.com.controle.cadastro.services.ISetorService;

@Component
public class SetorServiceImpl implements ISetorService{

	@Autowired
	private ISetorDAO dao;
	
	@Override
	public SetorEntity salvar(SetorEntity setor) {
		return dao.save(setor);
	}

	@Override
	public List<SetorEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public void excluir(SetorEntity setor) {
		dao.delete(setor);
		
	}

	@Override
	public SetorEntity getById(Integer id) {
		return dao.getById(id);
	}

}
