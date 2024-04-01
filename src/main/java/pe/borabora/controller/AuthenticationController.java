package pe.borabora.controller;

import jakarta.validation.Valid;
import pe.borabora.dto.request.CreateUserRequest;
import pe.borabora.dto.request.LoginRequest;
import pe.borabora.dto.response.AuthenticationResponse;
import pe.borabora.service.impl.UserDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid CreateUserRequest userRequest){
        return new ResponseEntity<>(this.userDetailService.createUser(userRequest), HttpStatus.CREATED);
    }

    @PostMapping("/log-in")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid LoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
    }
    
    /*
    @PutMapping("/{userId}")
	public ResponseEntity<String> updateUserDetails(@PathVariable Integer userId, @RequestBody CreateUser userDetails) {
		UserEntity userEntity = userDetailsService.getUserById(userId);
		if (userEntity == null) {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
		}

		// Actualiza los detalles del usuario
		userDetailsService.updateUserDetails(userEntity, userDetails);

		return new ResponseEntity<>("Detalles del usuario actualizados con éxito", HttpStatus.OK);
	}*/
}
