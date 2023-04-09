package br.com.controle.cadastro.DAO.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.cadastro.models.UsuarioEntity;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Integer> {

	@Query(" SELECT u FROM UsuarioEntity u WHERE u.delete = false ")
	Page<UsuarioEntity> getAllAtivos(Pageable page);

	
}
