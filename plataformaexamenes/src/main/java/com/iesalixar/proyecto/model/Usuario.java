package com.iesalixar.proyecto.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username",nullable=false, unique=true)
	private String userName;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false, columnDefinition="BOOLEAN")
	private boolean activo = true;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellidos;

	@Column(nullable=false)
	private String rol = "normal";
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Examen> examenes = new HashSet<>();
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Matricularse> matriculas = new HashSet<>();
	
	public Usuario() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Set<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
	}

	public Set<Matricularse> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricularse> matriculas) {
		this.matriculas = matriculas;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", activo=" + activo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", rol=" + rol
				+ ", examenes=" + examenes + ", matriculas=" + matriculas + "]";
	}

	
	
	
}
