package br.com.controle.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.cadastro.models.NivelFuncaoEntity;


@Service
public interface INivelFuncaoService {

	public NivelFuncaoEntity salvar(NivelFuncaoEntity nivelFuncao);

	public List<NivelFuncaoEntity> getAll();
	
	public void excluir(NivelFuncaoEntity nivelFuncao);
	
	public NivelFuncaoEntity getById(Integer id);
}
