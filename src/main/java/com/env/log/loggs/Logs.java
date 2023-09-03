package com.env.log.loggs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Logs {

	
	
	private static final Logger logger = LoggerFactory.getLogger(Logs.class);
	
	public void mensajeError(String localizacion,String mensaje,  String ObjetoString){
		logger.error("LOCALIZACION:   "+localizacion);
		logger.error("MENSAJE:  "+mensaje);		
		logger.error("OBJETO RECIBIDO:  "+ObjetoString);
	}
	
	public void mensajeOk(String mensaje){
		logger.info(mensaje);		
	}

	
	
}
