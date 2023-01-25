package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.FormaPagamentoEntity;

@Repository
public interface IFormaPagamentoDAO extends JpaRepository<FormaPagamentoEntity, Integer> {

}
