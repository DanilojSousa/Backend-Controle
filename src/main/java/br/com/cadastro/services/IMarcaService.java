package br.com.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastro.models.MarcaEntity;

@Service
public interface IMarcaService {
	
	public MarcaEntity salvar(MarcaEntity marca);
	
	public void excluir(MarcaEntity marca);
	
	public List<MarcaEntity> getAll();
	
	public List<MarcaEntity> getAllAtivos();
	
	public MarcaEntity getById(Integer id);
	
	public Boolean possueFornecedor(Integer id);

}
