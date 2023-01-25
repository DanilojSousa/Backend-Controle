package br.com.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastro.models.NivelFuncaoEntity;


@Service
public interface INivelFuncaoService {

	public NivelFuncaoEntity salvar(NivelFuncaoEntity nivelFuncao);

	public List<NivelFuncaoEntity> getAll();
	
	public void excluir(NivelFuncaoEntity nivelFuncao);
	
	public NivelFuncaoEntity getById(Integer id);
}
