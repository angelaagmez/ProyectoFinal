package com.iesalixar.proyecto.dto;

import java.io.Serializable;

public class UsuarioLoginDTO implements Serializable{
	private String userName;
	private String password;
	
	
	public UsuarioLoginDTO() {

	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
