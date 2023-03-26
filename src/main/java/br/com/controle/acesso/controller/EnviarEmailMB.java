package br.com.controle.acesso.controller;

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

import br.com.controle.acesso.models.EnviarEmailEntity;
import br.com.controle.acesso.services.IEnviarEmailService;
import br.com.controle.util.UrlFrontEnd;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path = "/email")
public class EnviarEmailMB {

	@Autowired
	private IEnviarEmailService dao;
	
	@PostMapping(path = "/salvar")
	public @ResponseBody EnviarEmailEntity salvar(@RequestBody EnviarEmailEntity enviarEmail) {	
	    return dao.salvar(enviarEmail);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<EnviarEmailEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public EnviarEmailEntity getById(Integer id) {	
		return  dao.getById(id);
	}
	
}
