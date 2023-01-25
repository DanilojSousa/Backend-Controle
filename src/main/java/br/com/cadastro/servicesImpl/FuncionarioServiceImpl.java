package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.IFuncionarioDAO;
import br.com.cadastro.models.FuncionarioEntity;
import br.com.cadastro.services.IFuncionarioService;

@Component
public class FuncionarioServiceImpl implements IFuncionarioService {

	@Autowired
	private IFuncionarioDAO dao;
	
	@Override
	public FuncionarioEntity salvar(FuncionarioEntity funcionario) {
		return dao.save(funcionario);
	}

	@Override
	public List<FuncionarioEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(FuncionarioEntity funcionario) {
		dao.delete(funcionario);
		
	}

	@Override
	public FuncionarioEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public List<FuncionarioEntity> pesquisa(String texto){
		return dao.pesquisa(texto);
	}

	@Override
	public Boolean possueSituacao(Integer id) {
		if(dao.getByIdPorSituacao(id).size() > 0) {
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
