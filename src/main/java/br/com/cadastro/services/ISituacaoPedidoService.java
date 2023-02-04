package br.com.cadastro.services;

import java.util.List;
import br.com.cadastro.models.SituacaoPedidoEntity;

public interface ISituacaoPedidoService {
	
	public SituacaoPedidoEntity salvar(SituacaoPedidoEntity situacaoPedido);
	
	public void excluir(SituacaoPedidoEntity situacaoPedido);
	
	public List<SituacaoPedidoEntity> getAll();
	
	public SituacaoPedidoEntity getById(Integer id);

}
