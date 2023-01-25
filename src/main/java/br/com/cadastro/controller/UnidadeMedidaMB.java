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

import br.com.cadastro.models.UnidadeMedidaEntity;
import br.com.cadastro.services.IUnidadeMedidaService;

@RestController
@RequestMapping(path = "/api/unidade")
public class UnidadeMedidaMB {
	
	@Autowired
	private IUnidadeMedidaService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody UnidadeMedidaEntity salvar(@RequestBody UnidadeMedidaEntity unidadeMedida) {
		return dao.salvar(unidadeMedida);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<UnidadeMedidaEntity> getAll(){
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public UnidadeMedidaEntity getById(Integer id) {	
		return  dao.getById(id);
	}

}
