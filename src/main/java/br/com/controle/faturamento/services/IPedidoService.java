package br.com.controle.faturamento.services;

import java.util.List;

import br.com.controle.faturamento.models.PedidoEntity;

public interface IPedidoService {

	public PedidoEntity salvar(PedidoEntity Pedido);

	public List<PedidoEntity> getAll();
	
	public List<PedidoEntity> getAllAtivos();
	
	public void excluir(PedidoEntity Pedido);
	
	public PedidoEntity getById(Integer id);
	
	public Boolean possueTipoPedido(Integer id);
	
	public Boolean possueFormaPagamento(Integer id);
	
	public Boolean possueSituacao(Integer id);
}
