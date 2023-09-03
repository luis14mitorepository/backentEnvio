package com.env.log.entity;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
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
@Table(name = "envio_maritimo")
public class EnvioMaritimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_envio_maritimo;
	
	
	
	
	
	@Min(value =1, message = "el campo  cantidad_producto no puede estar vacio tener o datos invalidos")
	private Integer cantidad_producto;
	
	@NotNull(message = "el campo fecha_registro  no puede estar o vacioo tener datos invalidos")
	private Date fecha_registro;
	
	@NotNull(message = "el campo fecha_entrega  no puede estar vacio o tener datos invalidos")
	private Date fecha_entrega;
	
		
	@Min(value = 1,message = "el campo precio_envio  no puede estar vacio o tener datos invalidos")
	private Float precio_envio;
	
	@NotNull(message = "el campo numero_flota  no puede estar vacio o tener datos invalidos")
	private String numero_flota;
	
	@NotNull(message = "el campo numero_guia  no puede estar vacio o tener datos invalidos")
	private String numero_guia;
	
	@NotNull(message = "el campo id_user  no puede estar vacio o tener datos invalidos") 
	@ManyToOne
	@JoinColumn(name = "id_user")
    private User user;
	
	@NotNull(message = "el campo id_puerto  no puede estar vacio o tener datos invalidos")
	@ManyToOne
	@JoinColumn(name = "id_puerto")
    private Puerto puerto;
	
	@NotNull(message = "el campo id_producto  no puede estar vacio o tener datos invalidos")
	@ManyToOne
	@JoinColumn(name = "id_producto")
    private Producto producto_maritimo;

	@Override
	public String toString() {
		return "EnvioMaritimo [id_envio_maritimo=" + id_envio_maritimo + ", cantidad_producto=" + cantidad_producto
				+ ", fecha_registro=" + fecha_registro + ", fecha_entrega=" + fecha_entrega + ", precio_envio="
				+ precio_envio + ", numero_flota=" + numero_flota + ", numero_guia=" + numero_guia + ", user=" + user
				+ ", puerto=" + puerto + ", producto_maritimo=" + producto_maritimo + "]";
	}

	public Long getId_envio_maritimo() {
		return id_envio_maritimo;
	}

	public void setId_envio_maritimo(Long id_envio_maritimo) {
		this.id_envio_maritimo = id_envio_maritimo;
	}

	public Integer getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Float getPrecio_envio() {
		return precio_envio;
	}

	public void setPrecio_envio(Float precio_envio) {
		this.precio_envio = precio_envio;
	}

	public String getNumero_flota() {
		return numero_flota;
	}

	public void setNumero_flota(String numero_flota) {
		this.numero_flota = numero_flota;
	}

	public String getNumero_guia() {
		return numero_guia;
	}

	public void setNumero_guia(String numero_guia) {
		this.numero_guia = numero_guia;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Puerto getPuerto() {
		return puerto;
	}

	public void setPuerto(Puerto puerto) {
		this.puerto = puerto;
	}

	public Producto getProducto_maritimo() {
		return producto_maritimo;
	}

	public void setProducto_maritimo(Producto producto_maritimo) {
		this.producto_maritimo = producto_maritimo;
	}

	
	
	

}
