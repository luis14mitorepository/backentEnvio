package com.env.log.services;



public class ValidarCampos {
	
	
	
	
	public boolean placaVehiculo(String placa) {	
		
		if(placa.length() != 6) {
			return false;
		}
		
		if(!placa.substring(0, 3).matches("[A-Z]*")){
			return false;
		}
		
		if(!placa.substring(3).matches("[0-9]*")){
			   return false;
			}
		
		return true;
				
	}

	public boolean guia(String guia) {	
		
		if(guia.length() != 10) {
			return false;
		}
		return true;
	}
	

	public boolean numeroFlota(String numeroFlota) {	
		
		if(numeroFlota.length() != 8) {
			return false;
		}
		
		if(!numeroFlota.substring(0, 3).matches("[A-Z]*")){
			return false;
		}
		
		if(!numeroFlota.substring(4,6).matches("[0-9]*")){
			   return false;
			}
		
		if(!numeroFlota.substring(7).matches("[A-Z]*")){
			return false;
		}
		return true;
				
	}
	
	
	
}
