package br.com.controle.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.cadastro.models.SetorEntity;

@Service
public interface ISetorService {

	public SetorEntity salvar(SetorEntity setor);

	public List<SetorEntity> getAll();
	
	public void excluir(SetorEntity setor);
	
	public SetorEntity getById(Integer id);
}
