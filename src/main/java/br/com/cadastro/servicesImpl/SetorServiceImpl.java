package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.ISetorDAO;
import br.com.cadastro.models.SetorEntity;
import br.com.cadastro.services.ISetorService;

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
