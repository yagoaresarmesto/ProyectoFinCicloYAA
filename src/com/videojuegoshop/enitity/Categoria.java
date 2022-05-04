package com.videojuegoshop.enitity;

//Generated 1 abr 2022 13:11:07 by Hibernate Tools 5.6.3.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "categoria", catalog = "videogameshopyaa")
@NamedQueries({
	@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c ORDER BY c.nombre"),
	@NamedQuery(name = "Categoria.countAll", query = "SELECT COUNT(*) FROM Categoria"),
	@NamedQuery(name = "Categoria.findByName", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre")
})

public class Categoria implements java.io.Serializable {

	private Integer categoriaId;
	private String nombre;
	private Set<Videojuego> videojuegos = new HashSet<Videojuego>(0);

	public Categoria() {
	}

	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(String nombre, Set<Videojuego> videojuegos) {
		this.nombre = nombre;
		this.videojuegos = videojuegos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id", unique = true, nullable = false)
	public Integer getCategoriaId() {
		return this.categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	@Column(name = "nombre", nullable = false, length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Videojuego> getVideojuegos() {
		return this.videojuegos;
	}

	public void setVideojuegos(Set<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}

}