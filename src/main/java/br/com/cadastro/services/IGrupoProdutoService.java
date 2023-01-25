package br.com.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastro.models.GrupoProdutoEntity;

@Service
public interface IGrupoProdutoService {

	public GrupoProdutoEntity salvar(GrupoProdutoEntity grupoProduto);
	
	public void excluir(GrupoProdutoEntity grupoProduto);
	
	public List<GrupoProdutoEntity> getAll();
	
	public GrupoProdutoEntity getById(Integer id);
	
	public Boolean possueProduto(Integer id);
}
