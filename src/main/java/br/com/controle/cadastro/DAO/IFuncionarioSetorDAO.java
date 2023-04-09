package br.com.controle.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.controle.cadastro.models.FuncionarioSetorEntity;
import br.com.controle.cadastro.models.UsuarioEntity;

@Repository
public interface IFuncionarioSetorDAO extends JpaRepository<FuncionarioSetorEntity, Integer> {

	@Query(value="select * from sistema_controle.funcionario_setor fs "
			+ "where fs.id_usuario = :id", nativeQuery = true)
	public List<FuncionarioSetorEntity> getByIdPorFuncionario(Integer id);

	@Query(value="select * from sistema_controle.funcionario_setor fs "
			+ "where fs.id_setor = :id", nativeQuery = true)
	List<FuncionarioSetorEntity> getByIdPorFuncao(Integer id);
	
	@Query(value="select * from sistema_controle.funcionario_setor fs "
			+ "where fs.id_nivel = :id", nativeQuery = true)
	List<FuncionarioSetorEntity> getByIdPorNivel(Integer id);
	
	@Query(value="select * from sistema_controle.funcionario_setor fs "
			+ "where fs.deletado = false", nativeQuery = true)
	List<FuncionarioSetorEntity> getAllAtivos();
	
	@Query(value="select * from sistema_controle.funcionario_setor fs "
			+ "where u.usuario.id = :id AND u.deletado = false ", nativeQuery = true)
	UsuarioEntity possueFornecedor(String id);
	
}
