package br.com.controle.acesso.security.JWT;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.controle.acesso.models.LoginEntity;
import br.com.controle.acesso.security.services.JWTTokenAutenticacaoService;
import br.com.controle.util.Util;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	//Configurando o gerenciador de autenticação
	public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
		//obriga autenticar a URL
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authenticationManager);
	}

	//retorna usuário ao processar a autenticação
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws org.springframework.security.core.AuthenticationException, IOException, ServletException {
		
		// obter Usuario
		LoginEntity login = new ObjectMapper().readValue(request.getInputStream(), LoginEntity.class);
		
		//retorna o user com login e senha
		try {
			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(
							Util.decode(login.getUsuario().getEmail()), 
							Util.decode(login.getPassword())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		try {
			new JWTTokenAutenticacaoService().addAuthentication(response, authResult.getName(), authResult.getAuthorities());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		
		if(failed instanceof BadCredentialsException) {
			response.getWriter().write("Usuario ou Senha não encontrado");
		}else {
			response.getWriter().write("Falha ao logar: " + failed.getMessage());
		}
	}
}
