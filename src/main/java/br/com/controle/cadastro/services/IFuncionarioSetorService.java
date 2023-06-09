package br.com.controle.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.cadastro.models.FuncionarioSetorEntity;

@Service
public interface IFuncionarioSetorService {

	public FuncionarioSetorEntity salvar(FuncionarioSetorEntity funcionarioSetor);

	public List<FuncionarioSetorEntity> getAll();
	
	public List<FuncionarioSetorEntity> getAllAtivos();
	
	public void excluir(FuncionarioSetorEntity funcionarioSetor);
	
	public FuncionarioSetorEntity getById(Integer id);
	
	public Boolean possueFuncionario(Integer id);
		
	public Boolean possueFuncao(Integer id);
	
	public Boolean possueNivel(Integer id);
}
