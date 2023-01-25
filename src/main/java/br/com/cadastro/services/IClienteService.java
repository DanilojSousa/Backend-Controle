package br.com.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastro.models.ClienteEntity;


@Service
public interface IClienteService {

	public ClienteEntity salvar(ClienteEntity cliente);

	public List<ClienteEntity> getAll();
	
	public void excluir(ClienteEntity cliente);
	
	public ClienteEntity getById(Integer id);
	
	public List<ClienteEntity> pesquisa(String texto);
	
	public Boolean possueSituacao(Integer id);
}
