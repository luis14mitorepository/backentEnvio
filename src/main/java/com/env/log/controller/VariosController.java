package com.env.log.controller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.env.log.entity.Bodega;
import com.env.log.entity.Producto;
import com.env.log.entity.Puerto;
import com.env.log.repository.*;

import org.springframework.web.bind.annotation.*;
import com.env.log.loggs.Logs;

@RestController
@RequestMapping("/")
public class VariosController {
	
	public Logs logs = new Logs();
	
	
	@Autowired
	private BodegaRepository bodegaRepository;
	
	
	@PostMapping("/create_bodega")
    public ResponseEntity<?> create_bodega(@RequestBody Bodega bodega){
		
		
		try {
			bodegaRepository.save(bodega);
			logs.mensajeOk(bodega.toString());
			return new ResponseEntity<>(bodega,HttpStatus.CREATED);
			
		} catch (Exception e) {					
			logs.mensajeError("com.env.log.controller.VariosController.create_bodega()",e.getMessage(),bodega.toString());			
			return new ResponseEntity<>(bodega,HttpStatus.NOT_ACCEPTABLE);					
		}		
		
    }
	
	
	
	@GetMapping("/get_bodega/{id}")
	public ResponseEntity<?> get_bodega(@PathVariable Long id){
		
	try {
		Optional<Bodega> bodega = bodegaRepository.findById(id);		
		
		return new ResponseEntity<>(bodega.get(),HttpStatus.OK);
			
		} catch (Exception e) {			
			logs.mensajeError("com.env.log.controller.VariosController.get_bodega()",e.getMessage(),id.toString());			
			return new ResponseEntity<>(id.toString(),HttpStatus.NOT_ACCEPTABLE);
					
		}
		
	}
	
	
	
	@PutMapping("/put_bodega/{id}")
	public  ResponseEntity<?> putUser(@RequestBody Bodega bodegaI, @PathVariable Long id) {
			
		  try {
			  bodegaRepository.findById(id)
				      .map(bodega -> {					    	  
				    	  bodega.setNombre_bodega(bodegaI.getNombre_bodega());
				    	  bodega.setCiudad_bodega(bodegaI.getCiudad_bodega());
				    	  bodega.setCodigo_bodega(bodegaI.getCodigo_bodega());
				    	  bodegaRepository.save(bodega);
				       return new ResponseEntity<>(bodegaI,HttpStatus.OK);     
				      })
				      .orElseGet(() -> {				    	  
				    	  bodegaRepository.save(bodegaI);
				         return new ResponseEntity<>(bodegaI,HttpStatus.OK);
				      });
			
				return new ResponseEntity<>(bodegaI,HttpStatus.OK);
			
		} catch (Exception e) {			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		 
		 		
	}
	
	
	@DeleteMapping("/delete_bodega/{id}")
	public ResponseEntity<?> delete_bodega(@PathVariable Long id) {
		try {			
			bodegaRepository.deleteById(id);
				return new ResponseEntity<>("La bodega fue borrado correctamente",HttpStatus.OK);			
		}catch (Exception e) {			
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	 }
	
	
	
	
	//****************************PUERTO****************************************
	
	


	@Autowired
	private PuertoRepository puertoRepository;
	
	
	@PostMapping("/create_puerto")
    public ResponseEntity<?> create_puerto(@RequestBody Puerto puerto){
		
		
		try {
			puertoRepository.save(puerto);
			logs.mensajeOk(puerto.toString());
			return new ResponseEntity<>(puerto,HttpStatus.CREATED);
			
		} catch (Exception e) {					
			logs.mensajeError("com.env.log.controller.VariosController.create_puerto()",e.getMessage(),puerto.toString());			
			return new ResponseEntity<>(puerto,HttpStatus.NOT_ACCEPTABLE);					
		}		
		
    }
	
	
	
	@GetMapping("/get_puerto/{id}")
	public ResponseEntity<?> get_puerto(@PathVariable Long id){
		
	try {
		Optional<Puerto> puerto = puertoRepository.findById(id);		
		
		return new ResponseEntity<>(puerto.get(),HttpStatus.OK);
			
		} catch (Exception e) {			
			logs.mensajeError("com.env.log.controller.VariosController.get_puerto()",e.getMessage(),id.toString());			
			return new ResponseEntity<>(id.toString(),HttpStatus.NOT_ACCEPTABLE);
					
		}
		
	}
	
	
	
	@PutMapping("/put_puerto/{id}")
	public  ResponseEntity<?> putUser(@RequestBody Puerto puertoI, @PathVariable Long id) {
			
		  try {
			  puertoRepository.findById(id)
				      .map(puerto -> {					    	  
				    	  puerto.setNombre_puerto(puertoI.getNombre_puerto());
				    	  puerto.setCiudad_puerto(puertoI.getCiudad_puerto());
				    	  puerto.setCodigo_puerto(puertoI.getCodigo_puerto());
				    	  puertoRepository.save(puerto);
				       return new ResponseEntity<>(puertoI,HttpStatus.OK);     
				      })
				      .orElseGet(() -> {				    	  
				    	  puertoRepository.save(puertoI);
				         return new ResponseEntity<>(puertoI,HttpStatus.OK);
				      });
			
				return new ResponseEntity<>(puertoI,HttpStatus.OK);
			
		} catch (Exception e) {			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		 
		 		
	}
	
	
	@DeleteMapping("/delete_puerto/{id}")
	public ResponseEntity<?> delete_puerto(@PathVariable Long id) {
		try {			
			puertoRepository.deleteById(id);
				return new ResponseEntity<>("La puerto fue borrado correctamente",HttpStatus.OK);			
		}catch (Exception e) {			
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	 }
	

	
	

//****************************************PRODUCTO************************************************************




	@Autowired
	private ProductoRepository productoRepository;


	@PostMapping("/create_producto")
	public ResponseEntity<?> create_Producto(@RequestBody Producto producto){
	
	
	try {
		productoRepository.save(producto);
		logs.mensajeOk(producto.toString());
		return new ResponseEntity<>(producto,HttpStatus.CREATED);
		
	} catch (Exception e) {					
		logs.mensajeError("com.env.log.controller.VariosController.create_Producto()",e.getMessage(),producto.toString());			
		return new ResponseEntity<>(producto,HttpStatus.NOT_ACCEPTABLE);					
	}		
	
}



@GetMapping("/get_producto/{id}")
public ResponseEntity<?> get_Producto(@PathVariable Long id){
	
try {
	Optional<Producto> Producto = productoRepository.findById(id);		
	
	return new ResponseEntity<>(Producto.get(),HttpStatus.OK);
		
	} catch (Exception e) {			
		logs.mensajeError("com.env.log.controller.VariosController.get_Producto()",e.getMessage(),id.toString());			
		return new ResponseEntity<>(id.toString(),HttpStatus.NOT_ACCEPTABLE);
				
	}
	
}



@PutMapping("/put_producto/{id}")
public  ResponseEntity<?> putUser(@RequestBody Producto productoI, @PathVariable Long id) {
		
	  try {
		  productoRepository.findById(id)
			      .map(producto -> {					    	  
			    	  producto.setNombre_producto(productoI.getNombre_producto());			    	  
			    	  producto.setCodigo_producto(productoI.getCodigo_producto());
			    	  producto.setDescripcion_producto(productoI.getDescripcion_producto());
			    	  productoRepository.save(producto);
			       return new ResponseEntity<>(productoI,HttpStatus.OK);     
			      })
			      .orElseGet(() -> {				    	  
			    	  productoRepository.save(productoI);
			         return new ResponseEntity<>(productoI,HttpStatus.OK);
			      });
		
			return new ResponseEntity<>(productoI,HttpStatus.OK);
		
	} catch (Exception e) {			
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	 
	 		
}


@DeleteMapping("/delete_producto/{id}")
public ResponseEntity<?> delete_Producto(@PathVariable Long id) {
	try {			
		productoRepository.deleteById(id);
			return new ResponseEntity<>("La Producto fue borrado correctamente",HttpStatus.OK);			
	}catch (Exception e) {			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
 }

}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


