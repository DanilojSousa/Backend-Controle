package br.com.controle.faturamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.faturamento.models.SituacaoPedidoEntity;
import br.com.controle.faturamento.services.ISituacaoPedidoService;
import br.com.controle.util.UrlFrontEnd;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path = "/situacao/pedido")
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
