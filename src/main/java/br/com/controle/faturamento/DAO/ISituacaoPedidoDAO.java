package br.com.controle.faturamento.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.faturamento.models.SituacaoPedidoEntity;

@Repository
public interface ISituacaoPedidoDAO extends JpaRepository<SituacaoPedidoEntity, Integer> {

}
