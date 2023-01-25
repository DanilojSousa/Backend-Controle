package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.SituacaoPedidoEntity;

@Repository
public interface ISituacaoPedidoDAO extends JpaRepository<SituacaoPedidoEntity, Integer> {

}
