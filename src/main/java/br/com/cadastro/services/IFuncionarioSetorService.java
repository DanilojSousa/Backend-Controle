package br.com.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastro.models.FuncionarioSetorEntity;

@Service
public interface IFuncionarioSetorService {

	public FuncionarioSetorEntity salvar(FuncionarioSetorEntity funcionarioSetor);

	public List<FuncionarioSetorEntity> getAll();
	
	public void excluir(FuncionarioSetorEntity funcionarioSetor);
	
	public FuncionarioSetorEntity getById(Integer id);
	
	public Boolean possueFuncionario(Integer id);
		
	public Boolean possueFuncao(Integer id);
}
