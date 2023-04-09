package br.com.controle.acesso.controller;

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

import br.com.controle.acesso.DAO.repository.LoginRepository;
import br.com.controle.acesso.models.LoginEntity;
import br.com.controle.acesso.security.config.WebConfigSecurity;
import br.com.controle.acesso.services.ILoginService;
import br.com.controle.cadastro.models.UsuarioEntity;
import br.com.controle.util.UrlFrontEnd;


@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path="/login")
public class LoginMB {
	
	@Autowired
	private ILoginService dao;
	
	@Autowired
	private LoginRepository repository;
	
	@PostMapping(path="/salvar")
	public @ResponseBody LoginEntity salva(@RequestBody LoginEntity produto) {
		produto.setPassword(new WebConfigSecurity().passwordEncoder().encode(produto.getPassword()));
		return dao.salvar(produto);
	}
	
	@DeleteMapping(value ="/delete/{id}")
	public void delete(@PathVariable(value="id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getById")
	public LoginEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	@GetMapping(path = "/getAll")
	public List<LoginEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/ativos")
	public List<LoginEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@GetMapping(path = "/getAllAtivos")
	public Page<LoginEntity> getAllAtivos(@RequestParam Integer pagina, @RequestParam Integer size) {
		PageRequest page = PageRequest.of(pagina, size, Sort.by("usuario.nome"));
		Page<LoginEntity> pageResultado = repository.getAllAtivos(page);
		return pageResultado;
	}
	
	@GetMapping(value = "/pesquisa/login/{nome}")
	public List<LoginEntity> pesquisaLogin(@PathVariable(value = "nome") String nome){
		nome.replace(" ", "%");
		return dao.pesquisaLogin(nome);
	}
		
}
