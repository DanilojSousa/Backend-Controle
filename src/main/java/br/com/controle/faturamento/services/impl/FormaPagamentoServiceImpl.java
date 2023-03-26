package br.com.controle.faturamento.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.faturamento.DAO.IFormaPagamentoDAO;
import br.com.controle.faturamento.models.FormaPagamentoEntity;
import br.com.controle.faturamento.services.IFormaPagamentoService;

@Component
public class FormaPagamentoServiceImpl implements IFormaPagamentoService {
	
	@Autowired
	private IFormaPagamentoDAO dao;

	@Override
	public FormaPagamentoEntity salvar(FormaPagamentoEntity formaPagamento) {
		return dao.save(formaPagamento);
	}

	@Override
	public List<FormaPagamentoEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public void excluir(FormaPagamentoEntity formaPagamento) {
		dao.delete(formaPagamento);
	}

	@Override
	public FormaPagamentoEntity getById(Integer id) {
		return dao.getById(id);
	}
	
}
