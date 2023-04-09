package br.com.controle.acesso.security.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.controle.acesso.models.LoginEntity;
import br.com.controle.acesso.models.RoleEntity;

public class DetalheUsuarioData implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private  LoginEntity login;
	
	public DetalheUsuarioData(LoginEntity login) {
		this.login = login;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(login.getUsuario().getRole());
		return roles;
	}

	@Override
	public String getPassword() {
		if(Objects.nonNull(login)) {
			try {
				return login.getPassword();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new LoginEntity().getPassword();
	}

	@Override
	public String getUsername() {
		if(Objects.nonNull(login)) {
			return login.getUsuario().getEmail();
		}
		return new LoginEntity().getUsuario().getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



}
