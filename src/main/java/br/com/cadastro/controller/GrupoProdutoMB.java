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

import br.com.cadastro.models.GrupoProdutoEntity;
import br.com.cadastro.services.IGrupoProdutoService;

@RestController
@RequestMapping(path="/api/grupoProduto")
public class GrupoProdutoMB {

	@Autowired
	private IGrupoProdutoService dao;
	
	@PostMapping(path="/salvar")
	public @ResponseBody GrupoProdutoEntity salvar(@RequestBody GrupoProdutoEntity grupoProduto) {
		return dao.salvar(grupoProduto);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path="/getAll")
	public List<GrupoProdutoEntity> getAll(){
		return dao.getAll();
	}
	
	@GetMapping(path = "/ativos")
	public List<GrupoProdutoEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@GetMapping(path="/getById")
	public GrupoProdutoEntity getById(Integer id){
		return dao.getById(id);
	}
	
	@GetMapping(value = "/produto/{id}")
	public Boolean possueProduto(@PathVariable(value = "id") String id){
		return dao.possueProduto(Integer.parseInt(id));
	}
}
