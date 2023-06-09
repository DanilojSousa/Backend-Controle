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

import br.com.controle.cadastro.models.NivelFuncaoEntity;
import br.com.controle.cadastro.services.INivelFuncaoService;
import br.com.controle.util.UrlFrontEnd;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path="/nivel/funcao")
public class NivelFuncaoMB {
	
	@Autowired
	private INivelFuncaoService dao;
	
	
	@PostMapping(path="/salvar")
	public @ResponseBody NivelFuncaoEntity salvar(@RequestBody NivelFuncaoEntity nivelFuncao) {
		return dao.salvar(nivelFuncao);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable(value = "id")Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<NivelFuncaoEntity> getAll(){
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public NivelFuncaoEntity getById(Integer id) {	
		return  dao.getById(id);
	}

}
