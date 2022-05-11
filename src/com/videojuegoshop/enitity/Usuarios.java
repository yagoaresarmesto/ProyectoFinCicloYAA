package com.videojuegoshop.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u ORDER BY u.apellidos"),
		@NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
		@NamedQuery(name = "Usuarios.countAll", query = "SELECT Count(*) FROM Usuarios u"),
		@NamedQuery(name = "Usuarios.checkLogin", query = "SELECT u FROM Usuarios u WHERE u.email = :email AND contrase�a = :contrase�a") })

public class Usuarios {

	private Integer usuarioId;
	private String email;
	private String apellidos;
	private String contrase�a;

	public Usuarios() {

	}

	public Usuarios(Integer usuarioId, String email, String apellidos, String contrase�a) {
		this(email, apellidos, contrase�a);
		this.usuarioId = usuarioId;
	}

	public Usuarios(String email, String apellidos, String contrase�a) {
		super();
		this.email = email;
		this.apellidos = apellidos;
		this.contrase�a = contrase�a;
	}

	@Column(name = "usuario_id") // Lo especifico porque en mi base de datos es diferente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

}