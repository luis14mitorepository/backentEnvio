package com.env.log.controller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.env.log.entity.EnvioMaritimo;
import com.env.log.repository.EnvioMaritimoRepository;
import org.springframework.web.bind.annotation.*;
import com.env.log.loggs.Logs;
import com.env.log.services.ValidarCampos;


@RestController
@RequestMapping("/")
public class EnvioMaritimoController {
	
	
	public  Logs logs = new Logs();
	public ValidarCampos validarCampos =new ValidarCampos();
	
	@Autowired
	private EnvioMaritimoRepository envioMaritimoRepository;
	
	
	@PostMapping("/create_Envio_maritimo")
    public ResponseEntity<?> create_Envio_maritimo(@RequestBody EnvioMaritimo envioMaritimo){
		 boolean valido = true;		 
		 
		
		 valido = validarCampos.numeroFlota(envioMaritimo.getNumero_flota());
		 if(valido == false) {
			 		logs.mensajeError("com.env.log.controller.EnvioMaritimoController.create_Envio_maritimo()","El formato de numero de flota no es correcto"
			 				,envioMaritimo.getNumero_flota());			 
			 		return new ResponseEntity<>(envioMaritimo,HttpStatus.NOT_ACCEPTABLE);
		 }
		 
		 valido = validarCampos.guia(envioMaritimo.getNumero_guia());
		 if(valido == false) {
			 		logs.mensajeError("com.env.log.controller.EnviomaritimoController.createUser()","El formato del numero de la guia no es correcto"
			 				,envioMaritimo.getNumero_guia());			 
			 		return new ResponseEntity<>(envioMaritimo.toString(),HttpStatus.NOT_ACCEPTABLE);
		 }
		 
		
		try {
			envioMaritimoRepository.save(envioMaritimo);
			logs.mensajeOk(envioMaritimo.toString());
			
			return new ResponseEntity<>(envioMaritimo,null,HttpStatus.CREATED);
			
		} catch (Exception e) {		
			
			logs.mensajeError("com.env.log.controller.EnviomaritimoController.createUser()",e.getMessage(),envioMaritimo.toString());			
			return new ResponseEntity<>(envioMaritimo,null,HttpStatus.NOT_ACCEPTABLE);
					
		}
		
		
    }
	
	
	
	@GetMapping("/get_envio_maritimo/{id}")
	public ResponseEntity<?> get_regis_log_maritimo(@PathVariable Long id){
				try {
					Optional<EnvioMaritimo> envioMaritimo = envioMaritimoRepository.findById(id);		
					
					return new ResponseEntity<>(envioMaritimo.toString(),HttpStatus.OK);
						
					} catch (Exception e) {			
						
						logs.mensajeError("com.env.log.controller.EnviomaritimoController.createUser()",e.getMessage(),id.toString());
						
						return new ResponseEntity<>(id.toString(),HttpStatus.NOT_ACCEPTABLE);
								
					}
					
	}
	
	
	
	@PutMapping("/put_envio_maritimo/{id}")
	public  ResponseEntity<?> put_regis_log_maritimo(@RequestBody EnvioMaritimo putEnvioMaritimo, @PathVariable Long id) {
		
		 boolean valido = true;
		 
		 valido = validarCampos.numeroFlota(putEnvioMaritimo.getNumero_flota());
		 if(valido == false) {
			 		logs.mensajeError("com.env.log.controller.EnviomaritimoController.createUser()","El formato de numero de flota no es correcto"
			 				,putEnvioMaritimo.getNumero_flota());			 
			 		return new ResponseEntity<>(putEnvioMaritimo,HttpStatus.NOT_ACCEPTABLE);
		 }
		 
		 valido = validarCampos.guia(putEnvioMaritimo.getNumero_guia());
		 if(valido == false) {
			 		logs.mensajeError("com.env.log.controller.EnviomaritimoController.createUser()","El formato del numero de la guia no es correcto"
			 				,putEnvioMaritimo.getNumero_guia());			 
			 		return new ResponseEntity<>(putEnvioMaritimo,HttpStatus.NOT_ACCEPTABLE);
		 }
		
		
		
		  try {
			  envioMaritimoRepository.findById(id)
				      .map(enviomaritimo -> {			    				    	  
				    	  
				    	  enviomaritimo.setCantidad_producto(putEnvioMaritimo.getCantidad_producto());
				    	  enviomaritimo.setFecha_registro(putEnvioMaritimo.getFecha_registro());
				    	  enviomaritimo.setFecha_entrega(putEnvioMaritimo.getFecha_entrega());
				    	  enviomaritimo.setPuerto(putEnvioMaritimo.getPuerto());
				    	  enviomaritimo.setPrecio_envio(putEnvioMaritimo.getPrecio_envio());
				    	  enviomaritimo.setNumero_flota(putEnvioMaritimo.getNumero_flota());
				    	  enviomaritimo.setNumero_guia(putEnvioMaritimo.getNumero_guia());
				    	  enviomaritimo.setProducto_maritimo(putEnvioMaritimo.getProducto_maritimo());
				    	  envioMaritimoRepository.save(enviomaritimo);
				       return new ResponseEntity<>(putEnvioMaritimo,HttpStatus.OK);     
				      })
				      .orElseGet(() -> {
				    	  putEnvioMaritimo.setId_envio_maritimo(id);
				    	  envioMaritimoRepository.save(putEnvioMaritimo);
				    	  return new ResponseEntity<>(putEnvioMaritimo,HttpStatus.OK);
				      });
			
				return new ResponseEntity<>(putEnvioMaritimo,HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		 
		 		
	}
	
	
	@DeleteMapping("/delete_envio_maritimo/{id}")
	public ResponseEntity<?> delete_regis_log_maritimo(@PathVariable Long id) {
				
		try {			
				envioMaritimoRepository.deleteById(id);
				return new ResponseEntity<>("El registro fue borrado correctamente",HttpStatus.OK);			
		}catch (Exception e) {			
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	  }
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


