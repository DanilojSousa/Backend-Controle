package br.com.controle.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.cadastro.models.UsuarioEntity;


@Service
public interface IUsuarioService {

	public UsuarioEntity salvar(UsuarioEntity usuario);

	public List<UsuarioEntity> getAll();
	
	public List<UsuarioEntity> getAllAtivos();
	
	public void excluir(UsuarioEntity usuario);
	
	public UsuarioEntity getById(Integer id);
	
	public List<UsuarioEntity> pesquisaFornecedor(String texto);
	
	public List<UsuarioEntity> pesquisaCliente(String texto);
	
	public List<UsuarioEntity> pesquisaFuncionario(String texto);
	
	public List<UsuarioEntity> pesquisaTodos(String texto);
	
	public Boolean possueSituacao(Integer id);
	
	public List<UsuarioEntity> fornecedores();
	
	public List<UsuarioEntity> clientes();
	
	public Boolean possueNivelAcesso(Integer id);
	
	public List<UsuarioEntity> funcionarios();

	
}
