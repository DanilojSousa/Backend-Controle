package br.com.controle.faturamento.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.faturamento.DAO.ISituacaoPedidoDAO;
import br.com.controle.faturamento.models.SituacaoPedidoEntity;
import br.com.controle.faturamento.services.ISituacaoPedidoService;

@Component
public class SituacaoPedidoServiceImpl implements ISituacaoPedidoService {
	
	@Autowired
	private ISituacaoPedidoDAO dao;

	@Override
	public SituacaoPedidoEntity salvar(SituacaoPedidoEntity situacaoPedido) {
		return dao.save(situacaoPedido);
	}

	@Override
	public List<SituacaoPedidoEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public void excluir(SituacaoPedidoEntity situacaoPedido) {
		dao.delete(situacaoPedido);
	}

	@Override
	public SituacaoPedidoEntity getById(Integer id) {
		return dao.getById(id);
	}
	

}
