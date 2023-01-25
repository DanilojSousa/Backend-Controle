package br.com.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.cadastro.models.TipoPedidoEntity;

@Repository
public interface ITipoPedidoDAO extends JpaRepository<TipoPedidoEntity, Integer> {

	@Query(value="select * from sistema_controle.tipo_pedido tp "
			+ "where tp.id_servico = :id", nativeQuery = true)
	public List<TipoPedidoEntity> getByIdPorServico(Integer id);

}
