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
@Table(name = "puerto")
public class Puerto {
	
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_puerto;
    
    @NotNull(message = "el campo nombre_puerto  no puede estar vacio o tener datos invalidos")
    private String nombre_puerto;
    
    @NotNull(message = "el campo codigo_puerto  no puede estar vacio o tener datos invalidos")
    private String codigo_puerto;
    
    @NotNull(message = "el campo ciudad_puerto  no puede estar vacio o tener datos invalidos")
    private String ciudad_puerto;
	
    @OneToMany(mappedBy ="puerto")
    private List<EnvioMaritimo> envio_maritimo;

	@Override
	public String toString() {
		return "Puerto [id_puerto=" + id_puerto + ", nombre_puerto=" + nombre_puerto + ", codigo_puerto="
				+ codigo_puerto + ", ciudad_puerto=" + ciudad_puerto + ", envio_maritimo=" + envio_maritimo + "]";
	}

	public Long getId_puerto() {
		return id_puerto;
	}

	public void setId_puerto(Long id_puerto) {
		this.id_puerto = id_puerto;
	}

	public String getNombre_puerto() {
		return nombre_puerto;
	}

	public void setNombre_puerto(String nombre_puerto) {
		this.nombre_puerto = nombre_puerto;
	}

	public String getCodigo_puerto() {
		return codigo_puerto;
	}

	public void setCodigo_puerto(String codigo_puerto) {
		this.codigo_puerto = codigo_puerto;
	}

	public String getCiudad_puerto() {
		return ciudad_puerto;
	}

	public void setCiudad_puerto(String ciudad_puerto) {
		this.ciudad_puerto = ciudad_puerto;
	}

	public List<EnvioMaritimo> getEnvio_maritimo() {
		return envio_maritimo;
	}

	public void setEnvio_maritimo(List<EnvioMaritimo> envio_maritimo) {
		this.envio_maritimo = envio_maritimo;
	}
    
    

	
	
	

}
