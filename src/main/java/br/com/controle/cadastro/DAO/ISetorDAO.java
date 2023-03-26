package br.com.controle.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.cadastro.models.SetorEntity;

@Repository
public interface ISetorDAO extends JpaRepository<SetorEntity, Integer> {

}
