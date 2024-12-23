package com.prueba.products.models.dto;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.*;

public class ProductDto {

	private Integer id;
	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
	private String nombre = "";
	@NotBlank(message = "La descripcion es obligatoria")
	@Size(min = 5, max = 100, message = "La descripcion debe tener entre 5 y 100 caracteres")
	private String descripcion = "";
	@DecimalMin(value = "0.01", message = "El precio debe ser mayor o igual a 0.01")
    @DecimalMax(value = "999999.99", message = "El precio debe ser menor o igual a 999999.99")
    @Digits(integer = 6, fraction = 2, message = "El precio debe tener como maximo 6 digitos enteros y 2 decimales")
	private float precio = 0f;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaCreacion;
	
	public ProductDto() {}
	
	public ProductDto(Integer id, String nombre, String descripcion, float precio
			, LocalDate fechaCreacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
	}
	
	public ProductDto(String nombre, String descripcion, float precio, 
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
