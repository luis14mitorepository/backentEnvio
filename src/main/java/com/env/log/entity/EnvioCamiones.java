package com.env.log.entity;



import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "envio_camiones")
public class EnvioCamiones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_envio_camiones;
	
	
	
	
	@Min(value =1, message = "el campo  cantidad_producto no puede estar vacio tener o datos invalidos")
	private Integer cantidad_producto;
	
	@NotNull(message = "el campo fecha_registro  no puede estar o vacioo tener datos invalidos")
	private Date fecha_registro;
	
	@NotNull(message = "el campo fecha_entrega  no puede estar vacio o tener datos invalidos")
	private Date fecha_entrega;
	
		
	@Min(value = 1,message = "el campo precio_envio  no puede estar vacio o tener datos invalidos")
	private Float precio_envio;
	
	@NotNull(message = "el campo placa_vehiculo  no puede estar vacio o tener datos invalidos")
	private String placa_vehiculo;
	
	@NotNull(message = "el campo numero_guia  no puede estar vacio o tener datos invalidos")
	private String numero_guia;
	
	 
	@ManyToOne
	@JoinColumn(name = "id_user")
    private User user;
	
	
	@ManyToOne
	@JoinColumn(name = "id_bodega")
    private Bodega bodega;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
    private Producto producto_camiones;

	@Override
	public String toString() {
		return "EnvioCamiones [id_envio_camiones=" + id_envio_camiones + ", cantidad_producto=" + cantidad_producto
				+ ", fecha_registro=" + fecha_registro + ", fecha_entrega=" + fecha_entrega + ", precio_envio="
				+ precio_envio + ", placa_vehiculo=" + placa_vehiculo + ", numero_guia=" + numero_guia + ", user="
				+ user + ", bodega=" + bodega + ", producto_camiones=" + producto_camiones + "]";
	}

	public Long getId_envio_camiones() {
		return id_envio_camiones;
	}

	public void setId_envio_camiones(Long id_envio_camiones) {
		this.id_envio_camiones = id_envio_camiones;
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

	public String getPlaca_vehiculo() {
		return placa_vehiculo;
	}

	public void setPlaca_vehiculo(String placa_vehiculo) {
		this.placa_vehiculo = placa_vehiculo;
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

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Producto getProducto_camiones() {
		return producto_camiones;
	}

	public void setProducto_camiones(Producto producto_camiones) {
		this.producto_camiones = producto_camiones;
	}

	
	
}
