package br.com.controle.cadastro.services;

import java.util.List;

import br.com.controle.cadastro.models.SituacaoEntity;

public interface ISituacaoService {
	
	public SituacaoEntity salvar(SituacaoEntity situacao);

	public List<SituacaoEntity> getAll();
	
	public void excluir(SituacaoEntity situacao);
	
	public SituacaoEntity getById(Integer id);
		
}
