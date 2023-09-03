package com.env.log.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "producto")
public class Producto {
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    
    @NotNull(message = "el campo nombre_producto  no puede estar vacio o tener datos invalidos")
    private String nombre_producto;
    
    @NotNull(message = "el campo codigo_producto  no puede estar vacio o tener datos invalidos")
    private String codigo_producto;
    
    @NotNull(message = "el campo descripcion_producto  no puede estar vacio o tener datos invalidos")
    private String descripcion_producto;
	
    @OneToMany(mappedBy ="producto_camiones")
    private List<EnvioCamiones> producto_camiones;
    
    @OneToMany(mappedBy ="producto_maritimo")
    private List<EnvioMaritimo> producto_maritimo;

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre_producto=" + nombre_producto + ", codigo_producto="
				+ codigo_producto + ", descripcion_producto=" + descripcion_producto + ", producto_camiones="
				+ producto_camiones + ", producto_maritimo=" + producto_maritimo + "]";
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public List<EnvioCamiones> getProducto_camiones() {
		return producto_camiones;
	}

	public void setProducto_camiones(List<EnvioCamiones> producto_camiones) {
		this.producto_camiones = producto_camiones;
	}

	public List<EnvioMaritimo> getProducto_maritimo() {
		return producto_maritimo;
	}

	public void setProducto_maritimo(List<EnvioMaritimo> producto_maritimo) {
		this.producto_maritimo = producto_maritimo;
	}

    
	
    
    
}
