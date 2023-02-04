package br.com.cadastro.services;

import java.util.List;

import br.com.cadastro.models.PedidoProdutoEntity;

public interface IPedidoProdutoService {
	
	public PedidoProdutoEntity salvar(PedidoProdutoEntity pedidoProduto);
	
	public void excluir(PedidoProdutoEntity pedidoProduto);
	
	public List<PedidoProdutoEntity> getAll();
	
	public List<PedidoProdutoEntity> getAllAtivos();
	
	public PedidoProdutoEntity getById(Integer id);

}
