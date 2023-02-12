package br.com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.DAO.Repository.ProdutoRepository;
import br.com.cadastro.models.ProdutoEntity;
import br.com.cadastro.models.UsuarioEntity;
import br.com.cadastro.services.IProdutoService;

@RestController
@RequestMapping(path="/api/produto")
public class ProdutoMB {
	
	@Autowired
	private IProdutoService dao;
	
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping(path="/salvar")
	public @ResponseBody ProdutoEntity salva(@RequestBody ProdutoEntity produto) {
		return dao.salvar(produto);
	}
	
	@DeleteMapping(value ="/delete/{id}")
	public void delete(@PathVariable(value="id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getById")
	public ProdutoEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	@GetMapping(path = "/getAll")
	public List<ProdutoEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/ativos")
	public List<ProdutoEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@GetMapping(value = "/pesquisa/{nome}")
	public List<ProdutoEntity> pesquisa(@PathVariable(value = "nome") String nome){
		nome.replace(" ", "%");
		return dao.pesquisa(nome);
	}
	
	@GetMapping(value = "/grupo/{id}")
	public Boolean possueGrupo(@PathVariable(value = "id") String id){
		return dao.possueGrupo(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/marca/{id}")
	public Boolean possueMarca(@PathVariable(value = "id") String id){
		return dao.possueMarca(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/ncm/{id}")
	public Boolean possueNcm(@PathVariable(value = "id") String id){
		return dao.possueNcm(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/medida/{id}")
	public Boolean possueMedida(@PathVariable(value = "id") String id){
		return dao.possueMedida(Integer.parseInt(id));
	}
	
	@GetMapping(value = "/situacao/{id}")
	public Boolean possueSituacao(@PathVariable(value = "id") String id){
		return dao.possueSituacao(Integer.parseInt(id));
	}
	
	@GetMapping(path = "/getAllAtivos")
	public Page<ProdutoEntity> getAllAtivos(@RequestParam Integer pagina, @RequestParam Integer size) {
		PageRequest page = PageRequest.of(pagina, size, Sort.by("nome"));
		Page<ProdutoEntity> pageResultado = repository.getAllAtivos(page);

		return pageResultado;
	}
}
