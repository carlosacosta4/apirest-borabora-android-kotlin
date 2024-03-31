package pe.borabora.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.borabora.dto.CreateUser;
import pe.borabora.entity.RoleEntity;
import pe.borabora.entity.UserEntity;
import pe.borabora.model.RoleEnum;
import pe.borabora.repository.RoleRepository;
import pe.borabora.repository.UserRepository;
import pe.borabora.service.impl.UserDetailsServiceImpl;

/*
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
	
	//Crear Usuario
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@Valid @RequestBody CreateUser createUser){

	    Set<RoleEntity> roles = createUser.getRoles().stream()
	            .map(role -> roleRepository.findByName(ERole.valueOf(role))
	                    .orElseThrow(() -> new RuntimeException("Error: Role is not found.")))
	            .collect(Collectors.toSet());

	    UserEntity userEntity = UserEntity.builder()
	            .identity_doc(createUser.getIdentity_doc())
	            .name(createUser.getName())
	            .lastname(createUser.getLastname())
	            .cellphone(createUser.getCellphone())
	            .email(createUser.getEmail())
	            .username(createUser.getUsername())
	            .password(passwordEncoder.encode(createUser.getPassword()))            
	            .roles(roles)
	            .build();

	    userRepository.save(userEntity);

	    return ResponseEntity.ok(userEntity);
	}
	
	Eliminar Usuario
	@DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Se ha borrado el user con id".concat(id);
    }
    */

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
	}
}    */

