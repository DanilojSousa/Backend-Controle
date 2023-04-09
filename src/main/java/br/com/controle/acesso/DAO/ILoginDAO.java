package br.com.controle.acesso.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.controle.acesso.models.LoginEntity;

@Repository
public interface ILoginDAO extends JpaRepository<LoginEntity, Integer> {

	@Query(value="select l from sistema_controle.login l "
			+ "where l.deletado = false ", nativeQuery = true)
	List<LoginEntity> getAllAtivos();

	@Query(value="SELECT l FROM LoginEntity l WHERE l.password = :password AND l.delete = false AND "
			+ " exists (SELECT u from UsuarioEntity u WHERE u.id = l.usuario.id AND u.email = :email AND u.delete = false) ")
	LoginEntity entrar(String email, String password);

	@Query(value="SELECT * FROM sistema_controle.login l WHERE l.deletado = false and "
			+ "exists (SELECT * from sistema_controle.usuario u where u.id_usuario = l.id_usuario and  u.email = :email AND u.deletado = false) ", nativeQuery = true)
	LoginEntity getByPorEmail(String email);
	
	@Query(value="select * from sistema_controle.login l "
			+ " where l.deletado = false AND exists( select * from sistema_controle.usuario u where u.id_usuario = l.id_usuario AND REPLACE(UPPER(u.nome), 'ÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ', 'NAEIOUAEIOUAOAEIOOAEIOUC') like %:texto% "
			+ " and u.deletado = false)", 
			nativeQuery = true)
	List<LoginEntity> pesquisaLogin(@Param("texto") String texto);
}
