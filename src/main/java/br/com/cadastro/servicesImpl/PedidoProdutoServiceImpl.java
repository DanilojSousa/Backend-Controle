package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.IPedidoProdutoDAO;
import br.com.cadastro.models.PedidoProdutoEntity;
import br.com.cadastro.services.IPedidoProdutoService;

@Component
public class PedidoProdutoServiceImpl  implements IPedidoProdutoService {
	
	@Autowired
	private IPedidoProdutoDAO dao;

	@Override
	public PedidoProdutoEntity salvar(PedidoProdutoEntity pedidoProduto) {
		return dao.save(pedidoProduto);
	}

	@Override
	public List<PedidoProdutoEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(PedidoProdutoEntity pedidoProduto) {
		dao.delete(pedidoProduto);
		
	}

	@Override
	public PedidoProdutoEntity getById(Integer id) {
		return dao.getById(id);
	}
}
