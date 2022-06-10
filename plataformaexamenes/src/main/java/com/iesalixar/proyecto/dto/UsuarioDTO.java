package com.iesalixar.proyecto.dto;

import java.io.Serializable;


/**
 * The Class UsuarioDTO.
 */
public class UsuarioDTO implements Serializable{
	
	/** The user name. */
	private String userName;
	
	/** The nombre. */
	private String nombre;
	
	/** The apellidos. */
	private String apellidos;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	
	
	/**
	 * Instantiates a new usuario DTO.
	 */
	public UsuarioDTO() {}
	
	/**
	 * Instantiates a new usuario DTO.
	 *
	 * @param userName the user name
	 * @param nombre the nombre
	 * @param apellidos the apellidos
	 * @param email the email
	 * @param password the password
	 */
	public UsuarioDTO(String userName, String nombre, String apellidos, String email, String password) {
		super();
		this.userName = userName;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
	}



	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
