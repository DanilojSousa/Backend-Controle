package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.IProdutoDAO;
import br.com.cadastro.models.ProdutoEntity;
import br.com.cadastro.services.IProdutoService;

@Component
public class ProdutoServiceImpl implements IProdutoService{

	@Autowired
	private IProdutoDAO dao;
	
	@Override
	public ProdutoEntity salvar(ProdutoEntity produto) {
		return dao.save(produto);
	}

	@Override
	public List<ProdutoEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(ProdutoEntity produto) {
		dao.delete(produto);
		
	}

	@Override
	public ProdutoEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public List<ProdutoEntity> pesquisa(String texto){
		return dao.pesquisa(texto);
	}
	
	@Override
	public Boolean possueGrupo(Integer id) {
		if(dao.getByIdPorGrupo(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean possueMarca(Integer id) {
		if(dao.getByIdPorMarca(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	@Override
	public Boolean possueNcm(Integer id) {
		if(dao.getByIdPorNcm(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	@Override
	public Boolean possueMedida(Integer id) {
		if(dao.getByIdPorMedida(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	@Override
	public Boolean possueSituacao(Integer id) {
		if(dao.getByIdPorSituacao(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
