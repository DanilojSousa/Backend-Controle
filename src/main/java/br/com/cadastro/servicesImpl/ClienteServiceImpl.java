package br.com.cadastro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.DAO.IClienteDAO;
import br.com.cadastro.models.ClienteEntity;
import br.com.cadastro.services.IClienteService;


@Component
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDAO dao;

	@Override
	public ClienteEntity salvar(ClienteEntity cliente) {
		return dao.save(cliente);
	}

	@Override
	public List<ClienteEntity> getAll() {
		return dao.findAll();
	}

	@Override
	public void excluir(ClienteEntity cliente) {
		dao.delete(cliente);
	}

	@Override
	public ClienteEntity getById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public List<ClienteEntity> pesquisa(String texto){
		return dao.pesquisa(texto);
	}

	@Override
	public Boolean possueSituacao(Integer id) {
		if(dao.getByIdPorSituacao(id).size() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	

	
}
