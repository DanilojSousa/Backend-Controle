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

import br.com.controle.cadastro.models.MarcaEntity;
import br.com.controle.cadastro.services.IMarcaService;
import br.com.controle.util.UrlFrontEnd;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path="/marca")
public class MarcaMB {
	
	@Autowired
	private IMarcaService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody MarcaEntity salvar(@RequestBody MarcaEntity marca) {
		return dao.salvar(marca);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<MarcaEntity> getAll(){
		return dao.getAll();
	}
	
	@GetMapping(path = "/ativos")
	public List<MarcaEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}
	
	@GetMapping(path = "/getById")
	public MarcaEntity getById(Integer id){
		return dao.getById(id);
	}
	
	@GetMapping(value = "/fornecedor/{id}")
	public Boolean possueFornecedor(@PathVariable(value = "id") String id){
		return dao.possueFornecedor(Integer.parseInt(id));
	}

}
