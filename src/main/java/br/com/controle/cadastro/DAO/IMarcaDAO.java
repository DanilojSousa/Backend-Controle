package br.com.controle.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.controle.cadastro.models.MarcaEntity;

@Repository
public interface IMarcaDAO extends JpaRepository<MarcaEntity, Integer> {
	
	@Query(value="select * from sistema_controle.marca m "
			+ "where m.id_fornecedor = :id", nativeQuery = true)
	List<MarcaEntity> getByIdPorFornecedor(Integer id);
	
	@Query(value="select * from sistema_controle.marca m "
			+ "where m.deletado = false", nativeQuery = true)
	List<MarcaEntity> getAllAtivos();

}
