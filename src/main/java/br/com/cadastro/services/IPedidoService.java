package br.com.cadastro.services;

import java.util.List;

import br.com.cadastro.models.PedidoEntity;

public interface IPedidoService {

	public PedidoEntity salvar(PedidoEntity Pedido);

	public List<PedidoEntity> getAll();
	
	public void excluir(PedidoEntity Pedido);
	
	public PedidoEntity getById(Integer id);
}
