package br.com.controle.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.cadastro.models.ProdutoEntity;

@Service
public interface IProdutoService {
	
	public ProdutoEntity salvar(ProdutoEntity produto);

	public List<ProdutoEntity> getAll();
	
	public List<ProdutoEntity> getAllAtivos();
	
	public void excluir(ProdutoEntity produto);
	
	public ProdutoEntity getById(Integer id);
	
	public List<ProdutoEntity> pesquisa(String texto);
	
	public Boolean possueGrupo(Integer id);
	
	public Boolean possueMarca(Integer id);

	public Boolean possueNcm(Integer id);

	public Boolean possueMedida(Integer id);
	
	public Boolean possueSituacao(Integer id);

}
