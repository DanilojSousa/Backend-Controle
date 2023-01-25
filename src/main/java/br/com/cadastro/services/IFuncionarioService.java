package br.com.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastro.models.FuncionarioEntity;

@Service
public interface IFuncionarioService {
	
	public FuncionarioEntity salvar(FuncionarioEntity funcionario);

	public List<FuncionarioEntity> getAll();
	
	public void excluir(FuncionarioEntity funcionario);
	
	public FuncionarioEntity getById(Integer id);
	
	public List<FuncionarioEntity> pesquisa(String texto);
	
	public Boolean possueSituacao(Integer id);
	
	public Boolean possueNivel(Integer id);

}
