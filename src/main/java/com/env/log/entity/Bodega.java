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
@Table(name = "bodega")
public class Bodega {
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bodega;
    
    @NotNull(message = "el campo nombre_bodega  no puede estar vacio o tener datos invalidos")
    private String nombre_bodega;
    
    @NotNull(message = "el campo codigo_bodega  no puede estar vacio o tener datos invalidos")
    private String codigo_bodega;
    
    @NotNull(message = "el campo ciudad_bodega  no puede estar vacio o tener datos invalidos")
    private String ciudad_bodega;
	
    @OneToMany(mappedBy ="bodega")
    private List<EnvioCamiones> envios_bodega;

	
    
    
    
    @Override
	public String toString() {
		return "Bodega [id_bodega=" + id_bodega + ", nombre_bodega=" + nombre_bodega + ", codigo_bodega="
				+ codigo_bodega + ", ciudad_bodega=" + ciudad_bodega + ", envios_bodega=" + envios_bodega + "]";
	}

	public Long getId_bodega() {
		return id_bodega;
	}

	public void setId_bodega(Long id_bodega) {
		this.id_bodega = id_bodega;
	}

	public String getNombre_bodega() {
		return nombre_bodega;
	}

	public void setNombre_bodega(String nombre_bodega) {
		this.nombre_bodega = nombre_bodega;
	}

	public String getCodigo_bodega() {
		return codigo_bodega;
	}

	public void setCodigo_bodega(String codigo_bodega) {
		this.codigo_bodega = codigo_bodega;
	}

	public String getCiudad_bodega() {
		return ciudad_bodega;
	}

	public void setCiudad_bodega(String ciudad_bodega) {
		this.ciudad_bodega = ciudad_bodega;
	}

	public List<EnvioCamiones> getEnvios_bodega() {
		return envios_bodega;
	}

	public void setEnvios_bodega(List<EnvioCamiones> envios_bodega) {
		this.envios_bodega = envios_bodega;
	}
    
    
    
    
	

}
