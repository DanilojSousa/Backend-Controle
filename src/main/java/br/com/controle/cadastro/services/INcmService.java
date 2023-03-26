package br.com.controle.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.controle.cadastro.models.NcmEntity;

@Service
public interface INcmService {
 
	public NcmEntity salvar(NcmEntity ncm);
	
	public void excluir(NcmEntity ncm);
	
	public List<NcmEntity> getAll();
	
	public NcmEntity getById(Integer id);
}
