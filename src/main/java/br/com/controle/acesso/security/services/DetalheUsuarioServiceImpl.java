package br.com.controle.acesso.security.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.controle.acesso.models.LoginEntity;
import br.com.controle.acesso.security.data.DetalheUsuarioData;
import br.com.controle.acesso.services.ILoginService;

@Service
public class DetalheUsuarioServiceImpl implements UserDetailsService {
	
	@Autowired
	private ILoginService loginService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LoginEntity login = loginService.getByPorEmail(email);
		if(Objects.isNull(login)) {
			throw new UsernameNotFoundException("E-mail "+email+" Não encontrado!");
		}
		return new DetalheUsuarioData(login);
	}

}
