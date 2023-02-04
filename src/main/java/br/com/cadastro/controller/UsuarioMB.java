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

import br.com.cadastro.models.UsuarioEntity;
import br.com.cadastro.services.IUsuarioService;


@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioMB {
	
	@Autowired
	private IUsuarioService dao;
	
	//INSERT CLIENTE
	@PostMapping(path = "/salvar")
	public @ResponseBody UsuarioEntity salvar(@RequestBody UsuarioEntity usuario) {	
	    return dao.salvar(usuario);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<UsuarioEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/ativos")
	public List<UsuarioEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@GetMapping(path = "/getById")
	public UsuarioEntity getById(Integer id) {	
		return  dao.getById(id);
	}

	@GetMapping(value = "/pesquisa/fornecedor/{nome}")
	public List<UsuarioEntity> pesquisaFornecedor(@PathVariable(value = "nome") String nome){
		nome.replace(" ", "%");
		return dao.pesquisaFornecedor(nome);
	}
	
	@GetMapping(value = "/pesquisa/cliente/{nome}")
	public List<UsuarioEntity> pesquisaCliente(@PathVariable(value = "nome") String nome){
		nome.replace(" ", "%");
		return dao.pesquisaCliente(nome);
	}
	
	@GetMapping(value = "/pesquisa/funcionario/{nome}")
	public List<UsuarioEntity> pesquisaFuncionario(@PathVariable(value = "nome") String nome){
		nome.replace(" ", "%");
		return dao.pesquisaFuncionario(nome);
	}
	
	@GetMapping(value = "/pesquisa/todos/{nome}")
	public List<UsuarioEntity> pesquisaTodos(@PathVariable(value = "nome") String nome){
		nome.replace(" ", "%");
		return dao.pesquisaTodos(nome);
	}
	
	@GetMapping(value = "/situacao/{id}")
	public Boolean possueSituacao(@PathVariable(value = "id") String id){
		return dao.possueSituacao(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/lista/fornecedores")
	public List<UsuarioEntity> fornecedores(){
		return dao.fornecedores();
	}
	
	@GetMapping(value = "/lista/clientes")
	public List<UsuarioEntity> pesquisaClientes(){
		return dao.clientes();
	}
	
	@GetMapping(value = "/lista/funcionarios")
	public List<UsuarioEntity> funcionarios(){
		return dao.funcionarios();
	}
}
