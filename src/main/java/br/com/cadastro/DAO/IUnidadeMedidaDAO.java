package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.UnidadeMedidaEntity;

@Repository
public interface IUnidadeMedidaDAO extends JpaRepository<UnidadeMedidaEntity, Integer>  {

}
