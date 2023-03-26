package br.com.controle.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.cadastro.models.NivelFuncaoEntity;

@Repository
public interface INivelFuncaoDAO extends JpaRepository<NivelFuncaoEntity, Integer>{
	

}
