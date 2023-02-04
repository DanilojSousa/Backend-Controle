package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.INivelFuncaoDAO;
import br.com.cadastro.models.NivelFuncaoEntity;
import br.com.cadastro.services.INivelFuncaoService;

@Component
public class NivelFuncaoServiceImpl implements INivelFuncaoService {
	
	@Autowired
	private INivelFuncaoDAO dao;

	@Override
	public NivelFuncaoEntity salvar(NivelFuncaoEntity nivelFuncao) {
		return dao.save(nivelFuncao);
	}

	@Override
	public List<NivelFuncaoEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public void excluir(NivelFuncaoEntity nivelFuncao) {
		dao.delete(nivelFuncao);
		
	}

	@Override
	public NivelFuncaoEntity getById(Integer id) {
		return dao.getById(id);
	}

}
