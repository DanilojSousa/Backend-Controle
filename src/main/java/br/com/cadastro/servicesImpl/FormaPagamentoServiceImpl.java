package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.IFormaPagamentoDAO;
import br.com.cadastro.models.FormaPagamentoEntity;
import br.com.cadastro.services.IFormaPagamentoService;

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
