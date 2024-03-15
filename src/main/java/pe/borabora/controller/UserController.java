package pe.borabora.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.borabora.dto.CreateUser;
import pe.borabora.entity.RoleEntity;
import pe.borabora.entity.UserEntity;
import pe.borabora.model.ERole;
import pe.borabora.repository.RoleRepository;
import pe.borabora.repository.UserRepository;


@RestController
public class UserController {

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
	
	/*
	Eliminar Usuario
	@DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Se ha borrado el user con id".concat(id);
    }
    */
}    

