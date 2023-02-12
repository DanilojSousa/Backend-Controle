package br.com.cadastro.DAO.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cadastro.models.ProdutoEntity;


public interface ProdutoRepository extends PagingAndSortingRepository<ProdutoEntity, Integer> {

	@Query(" SELECT p FROM ProdutoEntity p WHERE p.delete = false ")
	Page<ProdutoEntity> getAllAtivos(Pageable page);

}
