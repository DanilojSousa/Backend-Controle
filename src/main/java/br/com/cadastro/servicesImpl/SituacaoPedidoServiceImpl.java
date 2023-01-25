package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.ISituacaoPedidoDAO;
import br.com.cadastro.models.SituacaoPedidoEntity;
import br.com.cadastro.services.ISituacaoPedidoService;

@Component
public class SituacaoPedidoServiceImpl implements ISituacaoPedidoService {
	
	@Autowired
	private ISituacaoPedidoDAO dao;

	@Override
	public SituacaoPedidoEntity salvar(SituacaoPedidoEntity situacaoPedido) {
		return dao.save(situacaoPedido);
	}

	@Override
	public List<SituacaoPedidoEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(SituacaoPedidoEntity situacaoPedido) {
		dao.delete(situacaoPedido);
	}

	@Override
	public SituacaoPedidoEntity getById(Integer id) {
		return dao.getById(id);
	}
	

}
