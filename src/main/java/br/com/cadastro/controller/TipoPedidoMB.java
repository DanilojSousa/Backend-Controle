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

import br.com.cadastro.models.ClienteEntity;
import br.com.cadastro.models.TipoPedidoEntity;
import br.com.cadastro.services.ITipoPedidoService;

@RestController
@RequestMapping(path = "/api/tipoPedido")
public class TipoPedidoMB {

	@Autowired
	private ITipoPedidoService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody TipoPedidoEntity salvar(@RequestBody TipoPedidoEntity tipoPedido) {	
	    return dao.salvar(tipoPedido);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<TipoPedidoEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public TipoPedidoEntity getById(Integer id) {	
		return  dao.getById(id);
	}
	
	@GetMapping(value = "/servico/{id}")
	public Boolean possueServico(@PathVariable(value = "id") String id){
		return dao.possueServico(Integer.parseInt(id));
	}
	
}

