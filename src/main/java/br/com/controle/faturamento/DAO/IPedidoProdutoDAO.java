package br.com.controle.faturamento.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.controle.faturamento.models.PedidoProdutoEntity;

@Repository
public interface IPedidoProdutoDAO extends JpaRepository<PedidoProdutoEntity, Integer>{
	
	@Query(value="select * from sistema_controle.pedido_produto pp "
			+ "where pp.deletado = false", nativeQuery = true)
	List<PedidoProdutoEntity> getAllAtivos();

}
