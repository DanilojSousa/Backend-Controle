package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.ServicoEntity;

@Repository
public interface IServicoDAO extends JpaRepository<ServicoEntity, Integer>{

}
