package br.com.controle.faturamento.services;

import java.util.List;

import br.com.controle.faturamento.models.TipoPedidoEntity;

public interface ITipoPedidoService {

	public TipoPedidoEntity salvar(TipoPedidoEntity tipoPedido);

	public List<TipoPedidoEntity> getAll();
	
	public void excluir(TipoPedidoEntity tipoPedido);
	
	public TipoPedidoEntity getById(Integer id);
	
	public Boolean possueServico(Integer id);
	
}
