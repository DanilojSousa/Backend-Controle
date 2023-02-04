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

import br.com.cadastro.models.FuncionarioSetorEntity;
import br.com.cadastro.services.IFuncionarioSetorService;

@RestController
@RequestMapping(path = "/api/funcionarioSetor")
public class FuncionarioSetorMB {
	
	@Autowired
	private IFuncionarioSetorService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody FuncionarioSetorEntity salvar(@RequestBody FuncionarioSetorEntity funcionarioSetor) {	
	    return dao.salvar(funcionarioSetor);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<FuncionarioSetorEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/ativos")
	public List<FuncionarioSetorEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@GetMapping(path = "/getById")
	public FuncionarioSetorEntity getById(Integer id) {	
		return  dao.getById(id);
	}
	
	@GetMapping(value = "/funcionario/{id}")
	public Boolean getByPorFuncionario(@PathVariable(value = "id") Integer id) {
		return dao.possueFuncionario(id);
	}
	
	@GetMapping(value = "/funcao/{id}")
	public Boolean possueFuncao(@PathVariable(value = "id") String id){
		return dao.possueFuncao(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/empregado/{id}")
	public Boolean possueFuncionario(@PathVariable(value = "id") String id){
		return dao.possueFuncionario(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/nivel/{id}")
	public Boolean possueNivel(@PathVariable(value = "id") String id){
		return dao.possueNivel(Integer.parseInt(id));
	}
}
