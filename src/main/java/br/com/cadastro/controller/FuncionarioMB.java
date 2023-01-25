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

import br.com.cadastro.models.FuncionarioEntity;
import br.com.cadastro.services.IFuncionarioService;

@RestController
@RequestMapping(path="/api/funcionario")
public class FuncionarioMB {
	
	@Autowired
	private IFuncionarioService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody FuncionarioEntity salvar (@RequestBody FuncionarioEntity funcionario) {
		return dao.salvar(funcionario);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "getAll")
	public List<FuncionarioEntity> getAll(){
		return dao.getAll();
	}
	@GetMapping(path = "/getById")
	public FuncionarioEntity getById(Integer id){
		return dao.getById(id);
	}
	
	@GetMapping(value = "/pesquisa/{nome}")
	public List<FuncionarioEntity> pesquisa(@PathVariable(value = "nome") String nome){
		nome.replace(" ", "%");
		return dao.pesquisa(nome);
	}
	
	@GetMapping(value = "/situacao/{id}")
	public Boolean possueSituacao(@PathVariable(value = "id") String id){
		return dao.possueSituacao(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/nivel/{id}")
	public Boolean possueNivel(@PathVariable(value = "id") String id){
		return dao.possueNivel(Integer.parseInt(id));
	}

}
