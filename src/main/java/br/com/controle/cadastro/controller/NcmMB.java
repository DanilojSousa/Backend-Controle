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

import br.com.controle.cadastro.models.NcmEntity;
import br.com.controle.cadastro.services.INcmService;
import br.com.controle.util.UrlFrontEnd;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path="/ncm")
public class NcmMB {
	
	@Autowired
	private INcmService dao;
	
	@PostMapping(path="/salvar")
	public @ResponseBody NcmEntity salvar(@RequestBody NcmEntity ncm) {
		return dao.salvar(ncm);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable(value = "id")Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<NcmEntity> getAll(){
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public NcmEntity getById(Integer id){
		return dao.getById(id);
	}
}
