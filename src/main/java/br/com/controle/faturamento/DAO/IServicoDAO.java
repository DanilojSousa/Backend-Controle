package br.com.controle.faturamento.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.faturamento.models.ServicoEntity;

@Repository
public interface IServicoDAO extends JpaRepository<ServicoEntity, Integer>{

}
