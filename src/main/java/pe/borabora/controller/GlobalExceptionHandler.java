package pe.borabora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.borabora.dto.response.ErrorResponse;


@ControllerAdvice
public class GlobalExceptionHandler {

	 // Este método maneja la excepción BadCredentialsException, 
	 // que se lanza cuando la contraseña es incorrecta.
	 @ExceptionHandler(BadCredentialsException.class)
	 public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException ex) {
	     ErrorResponse errorResponse = new ErrorResponse();
	     errorResponse.setMessage("Contraseña incorrecta");
	     errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
	
	     return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	 }
	
	 // Este método maneja la excepción UsernameNotFoundException, 
	 // que se lanza cuando el usuario no se encuentra en la base de datos.
	 @ExceptionHandler(UsernameNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleUsernameNotFoundException(UsernameNotFoundException ex) {
	     ErrorResponse errorResponse = new ErrorResponse();
	     errorResponse.setMessage("Usuario no registrado");
	     errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

	     return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	 }
	 
	 // Manejo de las excepciones HttpMessageNotReadableException
	 @ExceptionHandler(HttpMessageNotReadableException.class)
	 public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		 ErrorResponse errorResponse = new ErrorResponse();
		 errorResponse.setMessage("Los datos enviados son incorrectos");
		 errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		 
         return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
     }
}
