package com.iesalixar.proyecto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * The Class JPAUserDetails.
 */
public class JPAUserDetails implements UserDetails{

	
	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The activo. */
	private boolean activo;
	
	/** The authorities. */
	private List<GrantedAuthority> authorities;
	
	/**
	 * Instantiates a new JPA user details.
	 *
	 * @param usuario the usuario
	 */
	public JPAUserDetails(Usuario usuario) {
		
		this.userName = usuario.getUserName();
		this.password = usuario.getPassword();
		this.activo = usuario.isActivo();
		this.authorities = new ArrayList<>();				
		this.authorities.add(new SimpleGrantedAuthority(usuario.getRol()));
		
	}

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.authorities;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return this.password;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return this.userName;
	}

	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
		return this.activo;
	}	

}
