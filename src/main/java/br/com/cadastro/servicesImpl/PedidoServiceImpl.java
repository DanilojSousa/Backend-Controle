package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.IPedidoDAO;
import br.com.cadastro.models.PedidoEntity;
import br.com.cadastro.services.IPedidoService;

@Component
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private IPedidoDAO dao;

	@Override
	public PedidoEntity salvar(PedidoEntity pedido) {
		return dao.save(pedido);
	}

	@Override
	public List<PedidoEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(PedidoEntity pedido) {
		dao.delete(pedido);
	}

	@Override
	public PedidoEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	
}
