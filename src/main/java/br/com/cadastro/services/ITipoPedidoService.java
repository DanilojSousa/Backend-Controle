package br.com.cadastro.services;

import java.util.List;

import br.com.cadastro.models.TipoPedidoEntity;

public interface ITipoPedidoService {

	public TipoPedidoEntity salvar(TipoPedidoEntity tipoPedido);

	public List<TipoPedidoEntity> getAll();
	
	public void excluir(TipoPedidoEntity tipoPedido);
	
	public TipoPedidoEntity getById(Integer id);
	
	public Boolean possueServico(Integer id);
	
}
