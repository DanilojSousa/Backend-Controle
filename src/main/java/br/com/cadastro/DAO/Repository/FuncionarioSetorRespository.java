package br.com.cadastro.DAO.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cadastro.models.FuncionarioSetorEntity;


public interface FuncionarioSetorRespository extends PagingAndSortingRepository<FuncionarioSetorEntity, Integer> {

		@Query(" SELECT f FROM FuncionarioSetorEntity f WHERE f.delete = false ")
		Page<FuncionarioSetorEntity> getAllAtivos(Pageable page);
		
}
