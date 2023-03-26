package br.com.controle.faturamento.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.faturamento.DAO.IPedidoDAO;
import br.com.controle.faturamento.models.PedidoEntity;
import br.com.controle.faturamento.services.IPedidoService;

@Component
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private IPedidoDAO dao;

	@Override
	public PedidoEntity salvar(PedidoEntity pedido) {
		return dao.save(pedido);
	}

	@Override
	public List<PedidoEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public List<PedidoEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}

	@Override
	public void excluir(PedidoEntity pedido) {
		dao.delete(pedido);
	}

	@Override
	public PedidoEntity getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public Boolean possueTipoPedido(Integer id) {
		if(dao.getByIdPorTipoPedido(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean possueFormaPagamento(Integer id) {
		if(dao.getByIdPorFormaPagamento(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean possueSituacao(Integer id) {
		if(dao.getByIdPorSituacao(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	
}
