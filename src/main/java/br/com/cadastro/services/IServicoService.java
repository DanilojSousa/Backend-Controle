package br.com.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastro.models.ServicoEntity;
import br.com.cadastro.models.TipoPedidoEntity;

@Service
public interface IServicoService {
	
	public ServicoEntity salvar(ServicoEntity servico);

	public List<ServicoEntity> getAll();
	
	public void excluir(ServicoEntity servico);
	
	public ServicoEntity getById(Integer id);
	
}
