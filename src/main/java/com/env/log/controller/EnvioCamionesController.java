package com.env.log.controller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.env.log.entity.EnvioCamiones;
import com.env.log.repository.EnvioCamionesRepository;
import org.springframework.web.bind.annotation.*;
import com.env.log.loggs.Logs;
import com.env.log.services.ValidarCampos;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/")
public class EnvioCamionesController {
	
	
	public  Logs logs = new Logs();
	public ValidarCampos validarCampos =new ValidarCampos();
	
	@Autowired
	private EnvioCamionesRepository envioCamionesRepository;
	
	@GetMapping("hello")	
	public String hello() {
		return "Hello World Not Secured";
	}
	
	
	@PostMapping("/create_envio_camiones")
    public ResponseEntity<?> create_Envio_camiones(@RequestBody EnvioCamiones envioCamiones){
		 boolean valido = true;		 
		 
		
		 valido = validarCampos.placaVehiculo(envioCamiones.getPlaca_vehiculo());
		 if(valido == false) {
			 		logs.mensajeError("com.env.log.controller.EnvioCamionesController.createUser()","El formato de placa del vehiculo no es correcto"
			 				,envioCamiones.getPlaca_vehiculo());			 
			 		return new ResponseEntity<>(envioCamiones,HttpStatus.NOT_ACCEPTABLE);
		 }
		 
		 valido = validarCampos.guia(envioCamiones.getNumero_guia());
		 if(valido == false) {
			 		logs.mensajeError("com.env.log.controller.EnvioCamionesController.createUser()","El formato del numero de la guia no es correcto"
			 				,envioCamiones.getNumero_guia());			 
			 		return new ResponseEntity<>(envioCamiones.toString(),HttpStatus.NOT_ACCEPTABLE);
		 }
		 
		
		try {
			envioCamionesRepository.save(envioCamiones);
			logs.mensajeOk(envioCamiones.toString());
			return new ResponseEntity<>(envioCamiones,null,HttpStatus.CREATED);
		} catch (Exception e) {			
				logs.mensajeError("com.env.log.controller.EnvioCamionesController.createUser()",e.getMessage(),envioCamiones.toString());			
			return new ResponseEntity<>(envioCamiones,null,HttpStatus.NOT_ACCEPTABLE);
					
		}
		
		
    }
	
	
	
	@GetMapping("/get_envio_camiones/{id}")
	public ResponseEntity<?> get_regis_log_camiones(@PathVariable Long id){
		
	try {
		Optional<EnvioCamiones> envioCamiones = envioCamionesRepository.findById(id);
		return new ResponseEntity<>(envioCamiones,HttpStatus.OK);
		} catch (Exception e) {			
			logs.mensajeError("com.env.log.controller.EnvioCamionesController.createUser()",e.getMessage(),id.toString());
			return new ResponseEntity<>(id.toString(),HttpStatus.NOT_ACCEPTABLE);
					
		}
		
		}
	
	
	
	@PutMapping("/put_envio_camiones/{id}")
	public  ResponseEntity<?> put_regis_log_camiones(@RequestBody EnvioCamiones putEnvioCamiones, @PathVariable Long id) {
		
		 boolean valido = true;
		 
		 valido = validarCampos.placaVehiculo(putEnvioCamiones.getPlaca_vehiculo());
		 if(valido == false) {
			 		logs.mensajeError("com.env.log.controller.EnvioCamionesController.createUser()","El formato de placa del vehiculo no es correcto"
			 				,putEnvioCamiones.getPlaca_vehiculo());			 
			 		return new ResponseEntity<>(putEnvioCamiones,HttpStatus.NOT_ACCEPTABLE);
		 }
		 
		 valido = validarCampos.guia(putEnvioCamiones.getNumero_guia());
		 if(valido == false) {
			 		logs.mensajeError("com.env.log.controller.EnvioCamionesController.createUser()","El formato del numero de la guia no es correcto"
			 				,putEnvioCamiones.getNumero_guia());			 
			 		return new ResponseEntity<>(putEnvioCamiones,HttpStatus.NOT_ACCEPTABLE);
		 }
				
		try {
			envioCamionesRepository.findById(id)
				      .map(envioCamiones -> {			    				    	  
				    	  envioCamiones.setProducto_camiones(putEnvioCamiones.getProducto_camiones());
				    	  envioCamiones.setCantidad_producto(putEnvioCamiones.getCantidad_producto());
				    	  envioCamiones.setFecha_registro(putEnvioCamiones.getFecha_registro());
				    	  envioCamiones.setFecha_entrega(putEnvioCamiones.getFecha_entrega());
				    	  envioCamiones.setBodega(putEnvioCamiones.getBodega());
				    	  envioCamiones.setPrecio_envio(putEnvioCamiones.getPrecio_envio());
				    	  envioCamiones.setPlaca_vehiculo(putEnvioCamiones.getPlaca_vehiculo());
				    	  envioCamiones.setNumero_guia(putEnvioCamiones.getNumero_guia());
				    	  
				        envioCamionesRepository.save(envioCamiones);
				       return new ResponseEntity<>(putEnvioCamiones,HttpStatus.OK);     
				      })
				      .orElseGet(() -> {
				    	  putEnvioCamiones.setId_envio_camiones(id);
				         envioCamionesRepository.save(putEnvioCamiones);
				         return new ResponseEntity<>(putEnvioCamiones,HttpStatus.OK);
				      });
			
				return new ResponseEntity<>(putEnvioCamiones,HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
			
		}	 
		 		
	}
	
	
	@DeleteMapping("/delete_envio_camiones/{id}")
	public ResponseEntity<?> delete_regis_log_camiones(@PathVariable Long id) {
				
		try {			
				envioCamionesRepository.deleteById(id);
				return new ResponseEntity<>("El registro fue borrado correctamente",HttpStatus.OK);			
		}catch (Exception e) {			
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	  }
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


