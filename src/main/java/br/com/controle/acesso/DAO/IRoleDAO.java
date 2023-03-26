package br.com.controle.acesso.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.acesso.models.RoleEntity;

@Repository
public interface IRoleDAO extends JpaRepository<RoleEntity, Integer> {

}
