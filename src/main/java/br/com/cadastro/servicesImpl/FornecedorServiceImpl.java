package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.IFornecedorDAO;
import br.com.cadastro.models.FornecedorEntity;
import br.com.cadastro.services.IFornecedorService;

@Component
public class FornecedorServiceImpl implements IFornecedorService {

	@Autowired
	private IFornecedorDAO dao;
	
	@Override
	public FornecedorEntity salvar(FornecedorEntity fornecedor) {
		return dao.save(fornecedor);
	}

	@Override
	public List<FornecedorEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(FornecedorEntity fornecedor) {
		dao.delete(fornecedor);
		
	}

	@Override
	public FornecedorEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public List<FornecedorEntity> pesquisa(String texto){
		return dao.pesquisa(texto);
	}

	@Override
	public Boolean possueSituacao(Integer id) {
		if(dao.getByIdPorSituacao(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}


}
