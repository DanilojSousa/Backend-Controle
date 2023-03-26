package br.com.controle.acesso.security.services;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.controle.acesso.DTO.RespostaToken;
import br.com.controle.acesso.models.LoginEntity;
import br.com.controle.acesso.security.JWT.ApplicationContextLoad;
import br.com.controle.acesso.security.data.DetalheUsuarioData;
import br.com.controle.acesso.services.ILoginService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
public class JWTTokenAutenticacaoService {

	private static final Integer EXPIRACAO = 86400000;
	public static final String SECRET = "SECRETY_CONTROLE_DANILO";
	public static final String HEADER = "Authorization";
	public static final String PREFIXO = "Bearer";
	
	@Autowired
	private ILoginService loginService;

	public void addAuthentication(HttpServletResponse response, String email) throws IOException {
		String JWT = Jwts.builder().setSubject(email).setExpiration(new Date(System.currentTimeMillis() + EXPIRACAO))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		String token = PREFIXO + " " + JWT;

		response.addHeader(HEADER, token);
		liberacaoCors(response);
		
		ObjectMapper objectMapper = new ObjectMapper();
		RespostaToken resposta = new RespostaToken();

		resposta.setData(new Date()); 
		resposta.setTempo(" 24 horas ");
		resposta.setMensagem("Autenticacao efetuado com sucesso");
		resposta.setSituacao(true);
		resposta.setRole(loginService.getByPorEmail(email).getUsuario().getRole().getNome());
		resposta.setToken("Authorization: " + token);
		
		response.getWriter().write(objectMapper.writeValueAsString(resposta));

	}
	//Retorna o usuário validado com token ou caso não seja retorna null
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String token = request.getHeader(HEADER);
		if(token != null) {
			
			try {			
				String tokenLimpo = token.replace(PREFIXO,"").trim();
				
				//faz a validação do token do usuário na requisição e obter o usuario
				String email = Jwts.parser()
						.setSigningKey(SECRET)
						.parseClaimsJws(tokenLimpo)
						.getBody()
						.getSubject();
				
				if(email != null) {
					LoginEntity login = ApplicationContextLoad.getApplicationContext()
							.getBean(ILoginService.class)
							.getByPorEmail(email);
					if(login != null) {
						DetalheUsuarioData user = new DetalheUsuarioData(login);
						return new UsernamePasswordAuthenticationToken(
								user.getUsername(),
								user.getPassword(), 
								user.getAuthorities());
					}
				}
				
			} catch (SignatureException e) {
				response.getWriter().write("Token está invalido");
			} catch (ExpiredJwtException e) {
				response.getWriter().write("Token está Expirado");
			}finally {
				liberacaoCors(response);
			}
		}

		return null;
	}

	private void liberacaoCors(HttpServletResponse response) {
		if (response.getHeader("Access-Control-Allow-Origin") == null) {
			response.addHeader("Access-Control-Allow-Origin", "*");
		}
		if (response.getHeader("Access-Control-Allow-Headers") == null) {
			response.addHeader("Access-Control-Allow-Headers", "*");
		}
		if (response.getHeader("Access-Control-Request-Headers") == null) {
			response.addHeader("Access-Control-Request-Headers", "*");
		}
		if (response.getHeader("Access-Control-Allow-Methods") == null) {
			response.addHeader("Access-Control-Allow-Methods", "*");
		}
	}
}
