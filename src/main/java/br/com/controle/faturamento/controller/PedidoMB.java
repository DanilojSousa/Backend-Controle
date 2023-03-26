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

import br.com.controle.faturamento.models.PedidoEntity;
import br.com.controle.faturamento.services.IPedidoService;
import br.com.controle.util.UrlFrontEnd;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path = "/pedido")
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
	
	@GetMapping(path = "/ativos")
	public List<PedidoEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@GetMapping(path = "/getById")
	public PedidoEntity getById(Integer id) {	
		return  dao.getById(id);
	}

	@GetMapping(value = "/tipoPedido/{id}")
	public Boolean possueTipoPedido(@PathVariable(value = "id") String id){
		return dao.possueTipoPedido(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/formaPagamento/{id}")
	public Boolean possueFormaPagamento(@PathVariable(value = "id") String id){
		return dao.possueFormaPagamento(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/situacao/{id}")
	public Boolean possueSituacao(@PathVariable(value = "id") String id){
		return dao.possueSituacao(Integer.parseInt(id));
	}
}
