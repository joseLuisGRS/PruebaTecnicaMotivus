package com.prueba.products.models.entity;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;
	@Column(nullable = false, length = 100)
	private String nombre;
	@Column(nullable = false, length = 100)
	private String descripcion;
	@Column(nullable = false)
	private float precio;
	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaCreacion;
	
	public Product() {}
	
	public Product(Integer id, String nombre, String descripcion, float precio
			, LocalDate fechaCreacion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
	}
	
	public Product(String nombre, String descripcion, float precio, 
			LocalDate fechaCreacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
