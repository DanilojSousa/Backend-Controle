package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.SetorEntity;

@Repository
public interface ISetorDAO extends JpaRepository<SetorEntity, Integer> {

}
