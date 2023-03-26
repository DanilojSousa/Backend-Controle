package br.com.controle.acesso.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.controle.acesso.models.EnviarEmailEntity;

@Repository
public interface IEnviarEmailDAO extends JpaRepository<EnviarEmailEntity, Integer> {

	@Query("SELECT ee FROM EnviarEmailEntity ee WHERE ee.enviado = false ")
	List<EnviarEmailEntity> getAllEmailNaoEnviado();

}
