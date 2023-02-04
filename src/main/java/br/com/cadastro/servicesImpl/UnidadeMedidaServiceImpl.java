package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.IUnidadeMedidaDAO;
import br.com.cadastro.models.UnidadeMedidaEntity;
import br.com.cadastro.services.IUnidadeMedidaService;

@Component
public class UnidadeMedidaServiceImpl implements IUnidadeMedidaService {
	
	@Autowired
	private IUnidadeMedidaDAO dao;

	@Override
	public UnidadeMedidaEntity salvar(UnidadeMedidaEntity unidadeMedida) {
		return dao.save(unidadeMedida);
	}

	@Override
	public List<UnidadeMedidaEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public void excluir(UnidadeMedidaEntity unidadeMedida) {
		dao.delete(unidadeMedida);
		
	}

	@Override
	public UnidadeMedidaEntity getById(Integer id) {
		return dao.getById(id);
	}

}
