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

import br.com.cadastro.models.FormaPagamentoEntity;
import br.com.cadastro.services.IFormaPagamentoService;

@RestController
@RequestMapping(path = "/api/formaPagamento")
public class FormaPagamentoMB {

	@Autowired
	private IFormaPagamentoService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody FormaPagamentoEntity salvar(@RequestBody FormaPagamentoEntity formaPagamento) {	
	    return dao.salvar(formaPagamento);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<FormaPagamentoEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public FormaPagamentoEntity getById(Integer id) {	
		return  dao.getById(id);
	}
	
}
