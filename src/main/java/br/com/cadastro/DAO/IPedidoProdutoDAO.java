package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.PedidoProdutoEntity;

@Repository
public interface IPedidoProdutoDAO extends JpaRepository<PedidoProdutoEntity, Integer>{

}
