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

import br.com.controle.acesso.models.RoleEntity;
import br.com.controle.acesso.services.IRoleService;
import br.com.controle.util.UrlFrontEnd;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path="/role")
public class RoleMB {

	@Autowired
	private IRoleService dao;
	
	@PostMapping(path="/salvar")
	public @ResponseBody RoleEntity salva(@RequestBody RoleEntity nivelAcesso) {
		return dao.salvar(nivelAcesso);
	}
	
	@DeleteMapping(value ="/delete/{id}")
	public void delete(@PathVariable(value="id") Integer id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getById")
	public RoleEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	@GetMapping(path = "/getAll")
	public List<RoleEntity> getAll() {
		return dao.getAll();
	}
	
}
