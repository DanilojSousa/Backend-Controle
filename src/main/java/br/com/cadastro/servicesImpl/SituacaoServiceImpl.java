package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.ISituacaoDAO;
import br.com.cadastro.models.SituacaoEntity;
import br.com.cadastro.services.ISituacaoService;

@Component
public class SituacaoServiceImpl implements ISituacaoService {
	
	@Autowired
	private ISituacaoDAO dao;

	@Override
	public SituacaoEntity salvar(SituacaoEntity situacao) {
		return dao.save(situacao);
	}

	@Override
	public List<SituacaoEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(SituacaoEntity situacao) {
		dao.delete(situacao);
		
	}

	@Override
	public SituacaoEntity getById(Integer id) {
		return dao.getById(id);
	}

	
	

}
