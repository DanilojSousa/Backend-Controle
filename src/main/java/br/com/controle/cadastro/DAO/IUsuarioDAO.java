package br.com.controle.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.controle.cadastro.models.UsuarioEntity;

@Repository
public interface IUsuarioDAO extends JpaRepository<UsuarioEntity, Integer> {
	
	@Query(value="select * from sistema_controle.usuario u "
			+ " where REPLACE(UPPER(u.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% "
			+ " and u.fornecedor = true and u.funcionario = false and u.cliente = false and u.deletado = false", 
			nativeQuery = true)
	List<UsuarioEntity> pesquisaFornecedor(@Param("texto") String texto);
	
	@Query(value="select * from sistema_controle.usuario u "
			+ " where REPLACE(UPPER(u.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% "
			+ " and u.cliente = true and u.fornecedor = false and u.funcionario = false and u.deletado = false", 
			nativeQuery = true)
	List<UsuarioEntity> pesquisaCliente(@Param("texto") String texto);
	
	@Query(value="select * from sistema_controle.usuario u "
			+ " where REPLACE(UPPER(u.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% "
			+ " and u.funcionario = true and u.fornecedor = false and u.cliente = false and u.deletado = false", 
			nativeQuery = true)
	List<UsuarioEntity> pesquisaFuncionario(@Param("texto") String texto);
	
	@Query(value="select * from sistema_controle.usuario u "
			+ "where REPLACE(UPPER(u.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% AND u.deletado = false ",
			nativeQuery = true)
	List<UsuarioEntity> pesquisaTodos(@Param("texto") String texto);

	
	@Query(value="select * from sistema_controle.usuario c "
			+ "where c.id_situacao = :id and c.deletado = false ", nativeQuery = true)
	List<UsuarioEntity> getByIdPorSituacao(Integer id);
	
	@Query(value="select * from sistema_controle.usuario u "
			+ "where u.fornecedor = true and u.cliente = false and u.funcionario = false and u.deletado = false", 
			nativeQuery = true)
	List<UsuarioEntity> fornecedores();
	
	@Query(value="select * from sistema_controle.usuario u "
			+ "where u.cliente = true and u.fornecedor = false and u.funcionario = false and u.deletado = false", 
			nativeQuery = true)
	List<UsuarioEntity> clientes();
	
	@Query(value="select * from sistema_controle.usuario u "
			+ "where u.funcionario = true and u.cliente = false and u.fornecedor = false and u.deletado = false",
			nativeQuery = true)
	List<UsuarioEntity> funcionarios();

	@Query(value="select * from sistema_controle.usuario c "
			+ "where c.id_nivel_acesso = :id and c.deletado = false ", nativeQuery = true)
	List<UsuarioEntity> getByIdPorNivelAcesso(Integer id);
	
	@Query(value="select * from sistema_controle.usuario u "
			+ "where u.deletado = false ", nativeQuery = true)
	List<UsuarioEntity> getAllAtivos();
	
	
} 