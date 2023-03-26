package br.com.controle.cadastro.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.acesso.models.LoginEntity;
import br.com.controle.acesso.services.ILoginService;
import br.com.controle.cadastro.DAO.repository.UsuarioRepository;
import br.com.controle.cadastro.models.UsuarioEntity;
import br.com.controle.cadastro.services.IUsuarioService;
import br.com.controle.util.UrlFrontEnd;


@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path = "/usuario")
public class UsuarioMB {
	
	@Autowired
	private IUsuarioService dao;
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private UsuarioRepository repository;
	
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
	
	@GetMapping(value = "/nivelAcesso/{id}")
	public Boolean possueNivelAcesso(@PathVariable(value = "id") String id){
		return dao.possueNivelAcesso(Integer.parseInt(id));
	}
	
	@GetMapping(path = "/getAllAtivos")
	public Page<UsuarioEntity> getAllAtivos(@RequestParam Integer pagina, @RequestParam Integer size) {
		PageRequest page = PageRequest.of(pagina, size, Sort.by("nome"));
		Page<UsuarioEntity> pageResultado = repository.getAllAtivos(page);

		return pageResultado;
	}
	
	@GetMapping(path = "/email")
	public LoginEntity getAllAtivos(@RequestParam String email) {
		return loginService.getByPorEmail(email);
	}
}
