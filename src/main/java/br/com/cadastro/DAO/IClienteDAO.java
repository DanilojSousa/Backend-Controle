package br.com.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.ClienteEntity;

@Repository
public interface IClienteDAO extends JpaRepository<ClienteEntity, Integer> {
	
	@Query(value="select * from sistema_controle.cliente c "
			+ "where REPLACE(UPPER(c.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% "
			+ "or REPLACE(UPPER(c.email), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% ", 
			nativeQuery = true)
	List<ClienteEntity> pesquisa(@Param("texto") String texto);

	
	@Query(value="select * from sistema_controle.cliente c "
			+ "where c.id_situacao = :id", nativeQuery = true)
	List<ClienteEntity> getByIdPorSituacao(Integer id);
			
} 