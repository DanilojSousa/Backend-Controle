package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.PedidoEntity;

@Repository
public interface IPedidoDAO extends JpaRepository<PedidoEntity, Integer> {

}
