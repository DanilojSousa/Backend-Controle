package br.com.controle.faturamento.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.faturamento.models.FormaPagamentoEntity;

@Repository
public interface IFormaPagamentoDAO extends JpaRepository<FormaPagamentoEntity, Integer> {


}
