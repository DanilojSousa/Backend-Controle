package br.com.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.cadastro.models.PedidoEntity;

@Repository
public interface IPedidoDAO extends JpaRepository<PedidoEntity, Integer> {
	
	@Query(value="select * from sistema_controle.pedido p "
			+ "where p.deletado = false", nativeQuery = true)
	List<PedidoEntity> getAllAtivos();
	
	@Query(value="select * from sistema_controle.pedido p "
			+ "where p.id_tipo_pedido = :id ", nativeQuery = true)
	List<PedidoEntity> getByIdPorTipoPedido(Integer id);
	
	@Query(value="select * from sistema_controle.pedido p "
			+ "where p.id_pagamento = :id ", nativeQuery = true)
	List<PedidoEntity> getByIdPorFormaPagamento(Integer id);
	
	@Query(value="select * from sistema_controle.pedido p "
			+ "where p.id_situacao_pedido = :id ", nativeQuery = true)
	List<PedidoEntity> getByIdPorSituacao(Integer id);

}
