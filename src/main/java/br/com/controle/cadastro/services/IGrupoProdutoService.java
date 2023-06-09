package br.com.controle.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.cadastro.models.GrupoProdutoEntity;

@Service
public interface IGrupoProdutoService {

	public GrupoProdutoEntity salvar(GrupoProdutoEntity grupoProduto);
	
	public void excluir(GrupoProdutoEntity grupoProduto);
	
	public List<GrupoProdutoEntity> getAll();
	
	public List<GrupoProdutoEntity> getAllAtivos();
	
	public GrupoProdutoEntity getById(Integer id);
	
	public Boolean possueProduto(Integer id);
}
