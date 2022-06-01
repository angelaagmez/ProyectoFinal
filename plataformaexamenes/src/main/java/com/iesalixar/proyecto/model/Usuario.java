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


/**
 * The Class Usuario.
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The user name. */
	@Column(name="username",nullable=false, unique=true)
	private String userName;
	
	/** The email. */
	@Column(nullable=false, unique=true)
	private String email;
	
	/** The password. */
	@Column(nullable=false)
	private String password;
	
	/** The activo. */
	@Column(nullable=false, columnDefinition="BOOLEAN")
	private boolean activo = true;
	
	/** The nombre. */
	@Column(nullable=false)
	private String nombre;
	
	/** The apellidos. */
	@Column(nullable=false)
	private String apellidos;

	/** The rol. */
	@Column(nullable=false)
	private String rol = "ROLE_USER";
	
	/** The examenes. */
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Examen> examenes = new HashSet<>();
	
	/** The matriculas. */
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Matricularse> matriculas = new HashSet<>();
	
	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * Checks if is activo.
	 *
	 * @return true, if is activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Sets the activo.
	 *
	 * @param activo the new activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the new rol
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Gets the examenes.
	 *
	 * @return the examenes
	 */
	public Set<Examen> getExamenes() {
		return examenes;
	}

	/**
	 * Sets the examenes.
	 *
	 * @param examenes the new examenes
	 */
	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
	}

	/**
	 * Gets the matriculas.
	 *
	 * @return the matriculas
	 */
	public Set<Matricularse> getMatriculas() {
		return matriculas;
	}

	/**
	 * Sets the matriculas.
	 *
	 * @param matriculas the new matriculas
	 */
	public void setMatriculas(Set<Matricularse> matriculas) {
		this.matriculas = matriculas;
	}

	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
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

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", activo=" + activo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", rol=" + rol
				+ ", examenes=" + examenes + ", matriculas=" + matriculas + "]";
	}

	
	
	
}
