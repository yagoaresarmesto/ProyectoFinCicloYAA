package com.videojuegoshop.enitity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Review generated by hbm2java
 */

@Entity
@Table(name = "review", catalog = "videogameshopyaa")
@NamedQueries({
	@NamedQuery(name = "Review.listAll", query = "SELECT r FROM Review r"),
	@NamedQuery(name = "Review.countAll", query = "SELECT COUNT(r) FROM Review r"),
	@NamedQuery(name = "Review.findByCustomerAndVideogame", 
	query = "SELECT r FROM Review r WHERE r.cliente.clienteId =:clienteId"
			+ " AND r.videojuego.videojuegoId =:videojuegoId"),
})
public class Review implements java.io.Serializable {

	private Integer reviewId;
	private Cliente cliente;
	private Videojuego videojuego;
	private int clasificacion;
	private String encabezado;
	private String comentario;
	private Date reviewFecha;

	public Review() {
	}

	public Review(Cliente cliente, Videojuego videojuego, int clasificacion, String encabezado, String comentario,
			Date reviewFecha) {
		this.cliente = cliente;
		this.videojuego = videojuego;
		this.clasificacion = clasificacion;
		this.encabezado = encabezado;
		this.comentario = comentario;
		this.reviewFecha = reviewFecha;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id", unique = true, nullable = false)
	public Integer getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "videojuego_id", nullable = false)
	public Videojuego getVideojuego() {
		return this.videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	@Column(name = "clasificacion", nullable = false)
	public int getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(int clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Column(name = "encabezado", nullable = false, length = 128)
	public String getEncabezado() {
		return this.encabezado;
	}

	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}
	@Column(name = "comentario", nullable = false, length = 500)
	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "review_fecha", nullable = false, length = 19)
	public Date getReviewFecha() {
		return this.reviewFecha;
	}

	public void setReviewFecha(Date reviewFecha) {
		this.reviewFecha = reviewFecha;
	}

	@Transient
	public String getStars() {
		String result = "";

		int numberOfStarsOn = (int) clasificacion;

		for (int i = 1; i <= numberOfStarsOn; i++) {
			result += "on,";
		}

		for (int j = numberOfStarsOn + 1; j <= 5; j++) {
			result += "off,";
		}

		return result.substring(0, result.length() - 1);
	}	

}