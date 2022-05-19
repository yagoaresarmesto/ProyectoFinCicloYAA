package com.videojuegoshop.enitity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.NamedQueries;


@Entity
@Table(name = "cliente", catalog = "videogameshopyaa", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NamedQueries({
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c ORDER BY c.email DESC"),
@NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
@NamedQuery(name = "Cliente.countAll", query = "SELECT COUNT(c.email) FROM Cliente c"),
})
public class Cliente implements java.io.Serializable {

	private Integer clienteId;
	private String email;
	private String nombrecompleto;
	private String direccion;
	private String ciudad;
	private String pais;
	private String telefono;
	private String codigopostal;
	private String contraseña;
	private Date fechaRegistro;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<VideojuegoPedido> videojuegoPedidos = new HashSet<VideojuegoPedido>(0);

	public Cliente() {
	}

	public Cliente(String email, String nombrecompleto, String direccion, String ciudad, String pais, String telefono,
			String codigopostal, String contraseña, Date fechaRegistro) {
		this.email = email;
		this.nombrecompleto = nombrecompleto;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
		this.telefono = telefono;
		this.codigopostal = codigopostal;
		this.contraseña = contraseña;
		this.fechaRegistro = fechaRegistro;
	}

	public Cliente(String email, String nombrecompleto, String direccion, String ciudad, String pais, String telefono,
			String codigopostal, String contraseña, Date fechaRegistro, Set<Review> reviews, Set<VideojuegoPedido> videojuegoPedidos) {
		this.email = email;
		this.nombrecompleto = nombrecompleto;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
		this.telefono = telefono;
		this.codigopostal = codigopostal;
		this.contraseña = contraseña;
		this.fechaRegistro = fechaRegistro;
		this.reviews = reviews;
		this.videojuegoPedidos = videojuegoPedidos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id", unique = true, nullable = false)
	public Integer getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	@Column(name = "email", unique = true, nullable = false, length = 64)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "nombrecompleto", nullable = false, length = 30)
	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	@Column(name = "direccion", nullable = false, length = 128)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Column(name = "ciudad", nullable = false, length = 32)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Column(name = "pais", nullable = false, length = 64)
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Column(name = "telefono", nullable = false, length = 15)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Column(name = "codigopostal", nullable = false, length = 24)
	public String getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	@Column(name = "contraseña", nullable = false, length = 16)
	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false, length = 19)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review>  reviews) {
		this.reviews = reviews;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<VideojuegoPedido> getVideojuegoPedidos() {
		return this.videojuegoPedidos;
	}

	public void setVideojuegoPedidos(Set<VideojuegoPedido> videojuegoPedidos) {
		this.videojuegoPedidos = videojuegoPedidos;
	}

}