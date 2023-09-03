package com.env.log.controller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.env.log.entity.User;
import com.env.log.repository.UserRepository;

import org.springframework.web.bind.annotation.*;
import com.env.log.loggs.Logs;
import com.env.log.services.ValidarCampos;


@RestController
@RequestMapping("/")
public class UserController {
	
	public Logs logs = new Logs();
	public ValidarCampos validarCampos =new ValidarCampos();
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/create_user")
    public ResponseEntity<?> createUser(@RequestBody User user){
		
		
		try {
			userRepository.save(user);
			logs.mensajeOk(user.toString());
			return new ResponseEntity<>(user,HttpStatus.CREATED);
			
		} catch (Exception e) {					
			logs.mensajeError("com.env.log.controller.UserController.create_user_log_camiones()",e.getMessage(),user.toString());			
			return new ResponseEntity<>(user,HttpStatus.NOT_ACCEPTABLE);					
		}		
		
    }
	
	
	
	@GetMapping("/get_user/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id){
		
	try {
		Optional<User> user = userRepository.findById(id);		
		
		return new ResponseEntity<>(user.get(),HttpStatus.OK);
			
		} catch (Exception e) {			
			logs.mensajeError("com.env.log.controller.EnvioCamionesController.getUser()",e.getMessage(),id.toString());			
			return new ResponseEntity<>(id.toString(),HttpStatus.NOT_ACCEPTABLE);
					
		}
		
	}
	
	
	
	@PutMapping("/put_user/{id}")
	public  ResponseEntity<?> putUser(@RequestBody User user11, @PathVariable Long id) {
			
		  try {
			  userRepository.findById(id)
				      .map(user -> {					    	  
				    	  user.setEmail(user11.getEmail());
				    	  user.setUsername(user11.getUsername());
				    	  user.setPassword(user11.getPassword());
				    	  
				    	  userRepository.save(user);
				       return new ResponseEntity<>(user11,HttpStatus.OK);     
				      })
				      .orElseGet(() -> {
				    	  
				    	  userRepository.save(user11);
				         return new ResponseEntity<>(user11,HttpStatus.OK);
				      });
			
				return new ResponseEntity<>(user11,HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		 
		 		
	}
	
	
	@DeleteMapping("/delete_user/{id}")
	public ResponseEntity<?> delete_regis_log_camiones(@PathVariable Long id) {
				
		try {			
			userRepository.deleteById(id);
				return new ResponseEntity<>("El usuario fue borrado correctamente",HttpStatus.OK);			
		}catch (Exception e) {			
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		
		
	  }
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


