package br.com.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.cadastro.models.FornecedorEntity;

@Service
public interface IFornecedorService {
	
	public FornecedorEntity salvar(FornecedorEntity fornecedor);

	public List<FornecedorEntity> getAll();
	
	public void excluir(FornecedorEntity fornecedor);
	
	public FornecedorEntity getById(Integer id);
	
	public List<FornecedorEntity> pesquisa(String texto);
	
	public Boolean possueSituacao(Integer id);
	
	
}

