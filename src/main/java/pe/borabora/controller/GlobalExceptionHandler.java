package pe.borabora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.borabora.dto.response.ApiResponse;


@ControllerAdvice
public class GlobalExceptionHandler {

	 // Este método maneja la excepción BadCredentialsException, 
	 // que se lanza cuando la contraseña es incorrecta.
	 @ExceptionHandler(BadCredentialsException.class)
	 public ResponseEntity<ApiResponse> handleBadCredentialsException(BadCredentialsException ex) {
	     ApiResponse apiResponse = new ApiResponse();
	     apiResponse.setMessage("Contraseña incorrecta");
	     apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
	
	     return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
	 }
	
	 // Este método maneja la excepción UsernameNotFoundException, 
	 // que se lanza cuando el usuario no se encuentra en la base de datos.
	 @ExceptionHandler(UsernameNotFoundException.class)
	 public ResponseEntity<ApiResponse> handleUsernameNotFoundException(UsernameNotFoundException ex) {
	     ApiResponse apiResponse = new ApiResponse();
	     apiResponse.setMessage("Usuario no registrado");
	     apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

	     return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
	 }

	 /*
	 // Manejo de las excepciones HttpMessageNotReadableException
	 @ExceptionHandler(HttpMessageNotReadableException.class)
	 public ResponseEntity<ApiResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		 ApiResponse apiResponse = new ApiResponse();
		 apiResponse.setMessage("Los datos enviados son incorrectos");
		 apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		 
         return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
     }*/
}
