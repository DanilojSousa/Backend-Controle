package br.com.cadastro.services;

import java.util.List;

import br.com.cadastro.models.FormaPagamentoEntity;

public interface IFormaPagamentoService {
	
	public FormaPagamentoEntity salvar(FormaPagamentoEntity formaPagamento);
	
	public void excluir(FormaPagamentoEntity formaPagamento);
	
	public List<FormaPagamentoEntity> getAll();
	
	public FormaPagamentoEntity getById(Integer id);

}
