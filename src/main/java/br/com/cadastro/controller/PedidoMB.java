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

import br.com.cadastro.models.PedidoEntity;
import br.com.cadastro.services.IPedidoService;

@RestController
@RequestMapping(path = "/api/pedido")
public class PedidoMB {
	
	@Autowired
	private IPedidoService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody PedidoEntity salvar(@RequestBody PedidoEntity pedido) {	
	    return dao.salvar(pedido);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<PedidoEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public PedidoEntity getById(Integer id) {	
		return  dao.getById(id);
	}

}
