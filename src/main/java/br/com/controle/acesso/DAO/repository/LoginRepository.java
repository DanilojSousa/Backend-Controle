package br.com.controle.acesso.DAO.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.controle.acesso.models.LoginEntity;

public interface LoginRepository extends PagingAndSortingRepository<LoginEntity, Integer> {
	
	@Query(" SELECT l FROM LoginEntity l WHERE l.delete = false AND l.usuario.delete = false ")
	Page<LoginEntity> getAllAtivos(Pageable page);

}
