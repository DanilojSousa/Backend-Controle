package br.com.controle.faturamento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.faturamento.models.ServicoEntity;

@Service
public interface IServicoService {
	
	public ServicoEntity salvar(ServicoEntity servico);

	public List<ServicoEntity> getAll();
	
	public void excluir(ServicoEntity servico);
	
	public ServicoEntity getById(Integer id);
	
}
