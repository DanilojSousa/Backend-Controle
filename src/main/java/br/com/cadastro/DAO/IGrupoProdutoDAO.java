package br.com.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.GrupoProdutoEntity;

@Repository
public interface IGrupoProdutoDAO extends JpaRepository<GrupoProdutoEntity, Integer> {
	
	@Query(value="select * from sistema_controle.grupo_produto gp "
			+ "where gp.id_produto = :id", nativeQuery = true)
	List<GrupoProdutoEntity> getByIdPorProduto(Integer id);
	
	@Query(value="select * from sistema_controle.grupo_produto gp "
			+ "where gp.deletado = false", nativeQuery = true)
	List<GrupoProdutoEntity> getAllAtivos();

}
