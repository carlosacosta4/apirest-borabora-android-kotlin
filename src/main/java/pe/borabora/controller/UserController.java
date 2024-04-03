package pe.borabora.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.borabora.dto.request.UserRequest;
import pe.borabora.dto.response.ApiResponse;
import pe.borabora.dto.response.UserResponse;
import pe.borabora.entity.UserEntity;
import pe.borabora.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/findUser/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if (userEntity.isPresent()) {
            UserEntity user = userEntity.get();
            UserResponse userResponse = new UserResponse(
            	user.getIdentityDoc(),
                user.getName(),
                user.getLastname(),
                user.getCellphone(),
                user.getEmail(),
                user.getUsername()
            );
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("No existe un usuario con el nombre de usuario proporcionado");
            apiResponse.setStatus(HttpStatus.NOT_FOUND.value());

            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/updateUser/{identityDoc}")
    public ResponseEntity<?> updateUser(@PathVariable Integer identityDoc, @RequestBody @Valid UserRequest userRequest){
        Optional<UserEntity> userEntity = userRepository.findByIdentityDoc(identityDoc);
        if (userEntity.isPresent()) {
            UserEntity user = userEntity.get();

            user.setName(userRequest.getName());
            user.setLastname(userRequest.getLastname());
            user.setCellphone(userRequest.getCellphone());
            user.setEmail(userRequest.getEmail());
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            
            userRepository.save(user);

            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("No existe un usuario con el documento de identidad proporcionado");
            apiResponse.setStatus(HttpStatus.NOT_FOUND.value());

            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }
}
