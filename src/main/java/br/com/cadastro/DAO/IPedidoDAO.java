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

}
