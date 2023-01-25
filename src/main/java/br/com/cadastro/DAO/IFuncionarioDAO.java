package br.com.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.FuncionarioEntity;

@Repository
public interface IFuncionarioDAO extends JpaRepository<FuncionarioEntity, Integer> {

	@Query(value="select * from sistema_controle.funcionario f "
			+ "where REPLACE(UPPER(f.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% "
			+ "or REPLACE(UPPER(f.email), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% ", 
			nativeQuery = true)
	List<FuncionarioEntity> pesquisa(@Param("texto") String texto);

	@Query(value="select * from sistema_controle.funcionario f "
			+ "where f.id_situacao = :id", nativeQuery = true)
	List<FuncionarioEntity> getByIdPorSituacao(Integer id);
	
	@Query(value="select * from sistema_controle.funcionario f "
			+ "where f.id_nivel = :id", nativeQuery = true)
	List<FuncionarioEntity> getByIdPorNivel(Integer id);

	

}
