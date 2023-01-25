package br.com.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.ClienteEntity;
import br.com.cadastro.models.FornecedorEntity;
import br.com.cadastro.models.SituacaoEntity;

@Repository
public interface IFornecedorDAO extends JpaRepository<FornecedorEntity, Integer>{
	
	@Query(value="select * from sistema_controle.fornecedor f "
			+ "where REPLACE(UPPER(f.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% "
			+ "or REPLACE(UPPER(f.email), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% ", 
			nativeQuery = true)
	List<FornecedorEntity> pesquisa(@Param("texto") String texto);

	@Query(value="select * from sistema_controle.fornecedor f "
			+ "where f.id_situacao = :id", nativeQuery = true)
	List<FornecedorEntity> getByIdPorSituacao(Integer id);		

}
