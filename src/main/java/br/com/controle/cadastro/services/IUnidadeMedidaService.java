package br.com.controle.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.cadastro.models.UnidadeMedidaEntity;

@Service
public interface IUnidadeMedidaService {
	
	public UnidadeMedidaEntity salvar(UnidadeMedidaEntity unidadeMedida);

	public List<UnidadeMedidaEntity> getAll();
	
	public void excluir(UnidadeMedidaEntity unidadeMedida);
	
	public UnidadeMedidaEntity getById(Integer id);

}
