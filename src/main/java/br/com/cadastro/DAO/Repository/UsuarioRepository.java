package br.com.cadastro.DAO.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.UsuarioEntity;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Integer> {

	@Query(" SELECT u FROM UsuarioEntity u WHERE u.cliente = true AND u.fornecedor = false AND u.funcionario = false AND u.delete = false ")
	Page<UsuarioEntity> getAllAtivos(Pageable page);

	
}
