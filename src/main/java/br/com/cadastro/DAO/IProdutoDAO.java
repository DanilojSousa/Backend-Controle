package br.com.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.FuncionarioSetorEntity;
import br.com.cadastro.models.PedidoProdutoEntity;
import br.com.cadastro.models.ProdutoEntity;

@Repository
public interface IProdutoDAO extends JpaRepository<ProdutoEntity, Integer>{
	
	@Query(value="select * from sistema_controle.produto p "
			+ "where REPLACE(UPPER(p.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% AND p.deletado = false", 
			nativeQuery = true)
	List<ProdutoEntity> pesquisa(@Param("texto") String texto);
	
	@Query(value="select * from sistema_controle.produto p "
			+ "where p.id_grupo = :id", nativeQuery = true)
	List<ProdutoEntity> getByIdPorGrupo(Integer id);
	
	@Query(value="select * from sistema_controle.produto p "
			+ "where p.id_marca = :id", nativeQuery = true)
	List<ProdutoEntity> getByIdPorMarca(Integer id);
	
	@Query(value="select * from sistema_controle.produto p "
			+ "where p.id_ncm = :id", nativeQuery = true)
	List<ProdutoEntity> getByIdPorNcm(Integer id);
	
	@Query(value="select * from sistema_controle.produto p "
			+ "where p.id_medida = :id", nativeQuery = true)
	List<ProdutoEntity> getByIdPorMedida(Integer id);

	@Query(value="select * from sistema_controle.produto p "
			+ "where p.id_situacao = :id", nativeQuery = true)
	List<ProdutoEntity> getByIdPorSituacao(Integer id);
	
	@Query(value="select * from sistema_controle.produto p "
			+ "where p.deletado = false", nativeQuery = true)
	List<ProdutoEntity> getAllAtivos();

}
