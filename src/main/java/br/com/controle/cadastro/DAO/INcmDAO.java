package br.com.controle.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.cadastro.models.NcmEntity;

@Repository
public interface INcmDAO extends JpaRepository<NcmEntity, Integer> {

}
