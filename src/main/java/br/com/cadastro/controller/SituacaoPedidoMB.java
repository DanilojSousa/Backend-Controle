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

import br.com.cadastro.models.SituacaoPedidoEntity;
import br.com.cadastro.services.ISituacaoPedidoService;

@RestController
@RequestMapping(path = "/api/situacaoPedido")
public class SituacaoPedidoMB {

	@Autowired
	private ISituacaoPedidoService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody SituacaoPedidoEntity salvar(@RequestBody SituacaoPedidoEntity situacaoPedido) {	
	    return dao.salvar(situacaoPedido);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<SituacaoPedidoEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public SituacaoPedidoEntity getById(Integer id) {	
		return  dao.getById(id);
	}

}
