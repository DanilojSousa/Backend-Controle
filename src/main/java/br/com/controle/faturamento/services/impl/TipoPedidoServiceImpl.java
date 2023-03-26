package br.com.controle.faturamento.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.faturamento.DAO.ITipoPedidoDAO;
import br.com.controle.faturamento.models.TipoPedidoEntity;
import br.com.controle.faturamento.services.ITipoPedidoService;

@Component
public class TipoPedidoServiceImpl implements ITipoPedidoService {
	
	@Autowired
	private ITipoPedidoDAO dao;

	@Override
	public TipoPedidoEntity salvar(TipoPedidoEntity tipoPedido) {
		return dao.save(tipoPedido);
	}

	@Override
	public List<TipoPedidoEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(TipoPedidoEntity tipoPedido) {
		dao.delete(tipoPedido);
	}

	@Override
	public TipoPedidoEntity getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public Boolean possueServico(Integer id) {
		if(dao.getByIdPorServico(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}


}
