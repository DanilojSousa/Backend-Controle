package br.com.controle.cadastro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.cadastro.DAO.INcmDAO;
import br.com.controle.cadastro.models.NcmEntity;
import br.com.controle.cadastro.services.INcmService;

@Component
public class NcmServiceImpl implements INcmService {
	
	@Autowired
	private INcmDAO dao;

	@Override
	public NcmEntity salvar(NcmEntity ncm) {
		return dao.save(ncm);
	}

	@Override
	public void excluir(NcmEntity ncm) {
		dao.delete(ncm);	
	}

	@Override
	public List<NcmEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public NcmEntity getById(Integer id) {
		return dao.getById(id);
	}

}
