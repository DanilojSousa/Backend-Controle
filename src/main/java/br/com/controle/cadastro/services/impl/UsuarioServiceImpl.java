package br.com.controle.cadastro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.controle.cadastro.DAO.IUsuarioDAO;
import br.com.controle.cadastro.models.UsuarioEntity;
import br.com.controle.cadastro.services.IUsuarioService;


@Component
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO dao;

	@Override
	public UsuarioEntity salvar(UsuarioEntity usuario) {
		return dao.save(usuario);
	}

	@Override
	public List<UsuarioEntity> getAll() {
		return dao.findAll();
	}
	
	@Override
	public List<UsuarioEntity> getAllAtivos() {
		return dao.getAllAtivos();
	}

	@Override
	public void excluir(UsuarioEntity usuario) {
		dao.delete(usuario);
	}

	@Override
	public UsuarioEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public List<UsuarioEntity> pesquisaFornecedor(String texto){
		return dao.pesquisaFornecedor(texto);
	}
	
	@Override
	public List<UsuarioEntity> pesquisaCliente(String texto){
		return dao.pesquisaCliente(texto);
	}
	
	@Override
	public List<UsuarioEntity> pesquisaFuncionario(String texto){
		return dao.pesquisaFuncionario(texto);
	}

	@Override
	public List<UsuarioEntity> pesquisaTodos(String texto){
		return dao.pesquisaTodos(texto);
	}
	
	@Override
	public Boolean possueSituacao(Integer id) {
		if(dao.getByIdPorSituacao(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public List<UsuarioEntity> fornecedores() {
		return dao.fornecedores();
	}

	@Override
	public List<UsuarioEntity> clientes() {
		return dao.clientes();
	}

	@Override
	public Boolean possueNivelAcesso(Integer id) {
		if(dao.getByIdPorNivelAcesso(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	@Override
	public List<UsuarioEntity> funcionarios() {
		return dao.funcionarios();
	}

	
}
