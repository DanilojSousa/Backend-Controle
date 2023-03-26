package br.com.controle.acesso.security.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.controle.acesso.security.JWT.JWTApiAutenticacaoFilter;
import br.com.controle.acesso.security.JWT.JWTLoginFilter;
import br.com.controle.acesso.security.services.DetalheUsuarioServiceImpl;

//Mapeae URL, endereços, autoriza ou bloqueia acesso a URL
@EnableWebSecurity
@Configuration
public class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionIdListener{

	@Autowired
	private DetalheUsuarioServiceImpl usuarioService;

	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.disable().authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		
		//redirecionar ou da um retorno para index quando desloga do sistema
		.anyRequest().authenticated().and().logout().logoutSuccessUrl("/login")
		
		//mapeia o logout do sistema
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		//Filtra as requisições para login de JWT
		.and().addFilterAfter(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new JWTApiAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
		// TODO Auto-generated method stub
		
	}
	



}
