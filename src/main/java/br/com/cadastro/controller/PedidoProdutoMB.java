package br.com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.models.PedidoProdutoEntity;
import br.com.cadastro.services.IPedidoProdutoService;

@RestController
@RequestMapping(path="/api/pedidoProduto")
public class PedidoProdutoMB {
	
	@Autowired
	private IPedidoProdutoService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody PedidoProdutoEntity salvar (@RequestBody PedidoProdutoEntity pedidoProduto) {
		return dao.salvar(pedidoProduto);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "getAll")
	public Iterable<PedidoProdutoEntity> getAll(){
		return dao.getAll();
	}
	
	@GetMapping(path = "/ativos")
	public List<PedidoProdutoEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@GetMapping(path = "/getById")
	public PedidoProdutoEntity getById(Integer id){
		return dao.getById(id);
	}
}
