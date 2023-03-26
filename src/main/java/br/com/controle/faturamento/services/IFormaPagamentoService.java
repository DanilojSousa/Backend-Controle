package br.com.controle.faturamento.services;

import java.util.List;

import br.com.controle.faturamento.models.FormaPagamentoEntity;

public interface IFormaPagamentoService {
	
	public FormaPagamentoEntity salvar(FormaPagamentoEntity formaPagamento);
	
	public void excluir(FormaPagamentoEntity formaPagamento);
	
	public List<FormaPagamentoEntity> getAll();
	
	public FormaPagamentoEntity getById(Integer id);

}
