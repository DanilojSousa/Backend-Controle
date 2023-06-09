package br.com.controle.cadastro.controller;

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

import br.com.controle.cadastro.models.SituacaoEntity;
import br.com.controle.cadastro.services.ISituacaoService;
import br.com.controle.util.UrlFrontEnd;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path = "/situacao")
public class SituacaoMB {

	@Autowired
	private ISituacaoService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody SituacaoEntity salvar(@RequestBody SituacaoEntity situacao) {
		return dao.salvar(situacao);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<SituacaoEntity> getAll(){
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public SituacaoEntity getById(Integer id) {	
		return  dao.getById(id);
	}
	
}
