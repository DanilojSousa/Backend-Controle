package br.com.controle.faturamento.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.faturamento.DAO.IServicoDAO;
import br.com.controle.faturamento.models.ServicoEntity;
import br.com.controle.faturamento.services.IServicoService;

@Component
public class ServicoServiceImpl implements IServicoService{

	@Autowired
	private IServicoDAO dao;
		
	@Override
	public ServicoEntity salvar(ServicoEntity servico) {
		return dao.save(servico);
	}

	@Override
	public List<ServicoEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public void excluir(ServicoEntity servico) {
		dao.delete(servico);
		
	}

	@Override
	public ServicoEntity getById(Integer id) {
		return dao.getById(id);
	}

}
