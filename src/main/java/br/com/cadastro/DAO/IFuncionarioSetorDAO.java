package br.com.cadastro.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.FuncionarioEntity;
import br.com.cadastro.models.FuncionarioSetorEntity;
import br.com.cadastro.models.SetorEntity;
import br.com.cadastro.models.SituacaoEntity;

@Repository
public interface IFuncionarioSetorDAO extends JpaRepository<FuncionarioSetorEntity, Integer> {

	@Query(value="select * from sistema_controle.funcionario_setor fs "
			+ "where fs.id_funcionario = :id", nativeQuery = true)
	public List<FuncionarioSetorEntity> getByIdPorFuncionario(Integer id);

	@Query(value="select * from sistema_controle.funcionario_setor fs "
			+ "where fs.id_setor = :id", nativeQuery = true)
	List<FuncionarioSetorEntity> getByIdPorFuncao(Integer id);
	
}
