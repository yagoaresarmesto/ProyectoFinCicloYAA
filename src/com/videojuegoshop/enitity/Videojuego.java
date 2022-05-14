package com.videojuegoshop.enitity;

import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * Videojuego generated by hbm2java
 */

@Entity
@Table(name = "videojuego", catalog = "videogameshopyaa", uniqueConstraints = @UniqueConstraint(columnNames = {
		"titulo" }))
@NamedQueries({
	@NamedQuery(name = "Videojuego.findAll", query = "SELECT v FROM Videojuego v"),
	@NamedQuery(name = "Videojuego.findByTitle", query = "SELECT v FROM Videojuego v WHERE v.titulo = :titulo"),
	@NamedQuery(name = "Videojuego.countAll", query = "SELECT COUNT(*) FROM Videojuego v")
})
public class Videojuego implements java.io.Serializable {

	private Integer videojuegoId;
	private Categoria categoria;
	private String titulo;
	private String compa�ia;
	private String descripcion;
	private byte[] imagen;
	private String base64Image;
	private float precio;
	private Date fechaPublicacion;
	private Date fechaActualizacion;
	private Set<DetallesPedido> detallesPedidos = new HashSet<DetallesPedido>(0);
	private Set<Review> reviews = new HashSet<Review>(0);

	public Videojuego() {
	}

	public Videojuego(Categoria categoria, String titulo, String compa�ia, String descripcion, byte[] imagen,
			float precio, Date fechaPublicacion, Date fechaActualizacion) {
		this.categoria = categoria;
		this.titulo = titulo;
		this.compa�ia = compa�ia;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	public Videojuego(Categoria categoria, String titulo, String compa�ia, String descripcion, byte[] imagen,
			float precio, Date fechaPublicacion, Date fechaActualizacion, Set<DetallesPedido> detallesPedidos,
			Set<Review> reviews) {
		this.categoria = categoria;
		this.titulo = titulo;
		this.compa�ia = compa�ia;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.fechaActualizacion = fechaActualizacion;
		this.detallesPedidos = detallesPedidos;
		this.reviews = reviews;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "videojuego_id", unique = true, nullable = false)
	public Integer getVideojuegoId() {
		return this.videojuegoId;
	}

	public void setVideojuegoId(Integer videojuegoId) {
		this.videojuegoId = videojuegoId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Column(name = "titulo", unique = true, nullable = false, length = 128)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "compa�ia", nullable = false, length = 64)
	public String getCompa�ia() {
		return this.compa�ia;
	}

	public void setCompa�ia(String compa�ia) {
		this.compa�ia = compa�ia;
	}

	@Column(name = "descripcion", nullable = false, length = 16777215)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "imagen", nullable = false)
	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Column(name = "precio", nullable = false, precision = 12, scale = 0)
	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_publicacion", nullable = false, length = 10)
	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", nullable = false, length = 19)
	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "videojuego")
	public Set<DetallesPedido> getDetallesPedidos() {
		return this.detallesPedidos;
	}

	public void setDetallesPedidos(Set<DetallesPedido> detallesPedidos) {
		this.detallesPedidos = detallesPedidos;
	}
	
	@Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.imagen);
		return this.base64Image;
	}
	
	@Transient
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((videojuegoId == null) ? 0 : videojuegoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		if (videojuegoId == null) {
			if (other.videojuegoId != null)
				return false;
		} else if (!videojuegoId.equals(other.videojuegoId))
			return false;
		return true;
	}

	


}