package br.com.cadastro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.models.NcmEntity;

@Repository
public interface INcmDAO extends JpaRepository<NcmEntity, Integer> {

}
