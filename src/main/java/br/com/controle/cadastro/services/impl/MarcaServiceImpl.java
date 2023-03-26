package br.com.controle.cadastro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.cadastro.DAO.IMarcaDAO;
import br.com.controle.cadastro.models.MarcaEntity;
import br.com.controle.cadastro.services.IMarcaService;

@Component
public class MarcaServiceImpl implements IMarcaService {

	@Autowired
	private IMarcaDAO dao;
	
	@Override
	public MarcaEntity salvar(MarcaEntity marca) {
		return dao.save(marca);
	}

	@Override
	public void excluir(MarcaEntity marca) {
		dao.delete(marca);		
	}

	@Override
	public List<MarcaEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public List<MarcaEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@Override
	public MarcaEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	
	@Override
	public Boolean possueFornecedor(Integer id) {
		if(dao.getByIdPorFornecedor(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
