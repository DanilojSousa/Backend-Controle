package br.com.controle.cadastro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.cadastro.DAO.IGrupoProdutoDAO;
import br.com.controle.cadastro.models.GrupoProdutoEntity;
import br.com.controle.cadastro.services.IGrupoProdutoService;

@Component
public class GrupoProdutoServiceImpl implements IGrupoProdutoService {
	
	@Autowired
	private IGrupoProdutoDAO dao;

	@Override
	public GrupoProdutoEntity salvar(GrupoProdutoEntity grupoProduto) {
		return dao.save(grupoProduto);
	}

	@Override
	public void excluir(GrupoProdutoEntity grupoProduto) {
		dao.delete(grupoProduto);
	}

	@Override
	public List<GrupoProdutoEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public List<GrupoProdutoEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}

	@Override
	public GrupoProdutoEntity getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public Boolean possueProduto(Integer id) {
		if(dao.getByIdPorProduto(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
