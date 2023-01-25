package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.SituacaoEntity;

@Repository
public interface ISituacaoDAO extends JpaRepository<SituacaoEntity, Integer>{

	
}
