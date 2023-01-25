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

import br.com.cadastro.models.FornecedorEntity;
import br.com.cadastro.services.IFornecedorService;

@RestController
@RequestMapping(path="/api/fornecedor")
public class FornecedorMB {

	@Autowired
	private IFornecedorService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody FornecedorEntity salvar (@RequestBody FornecedorEntity fornecedor) {
		return dao.salvar(fornecedor);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<FornecedorEntity> getAll(){
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public FornecedorEntity getById(Integer id){
		return dao.getById(id);
	}
	
	@GetMapping(value = "/pesquisa/{nome}")
	public List<FornecedorEntity> pesquisa(@PathVariable(value = "nome") String nome){
		nome.replace(" ", "%");
		return dao.pesquisa(nome);
	}
	
	@GetMapping(value = "/situacao/{id}")
	public Boolean possueSituacao(@PathVariable(value = "id") String id){
		return dao.possueSituacao(Integer.parseInt(id));
	}
	
}