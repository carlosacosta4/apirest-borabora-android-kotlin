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
import pe.borabora.dto.request.UpdateUserRequest;
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
    public ResponseEntity<?> updateUser(@PathVariable Integer identityDoc, @RequestBody @Valid UpdateUserRequest updateUserRequest){
        Optional<UserEntity> userEntity = userRepository.findByIdentityDoc(identityDoc);
        if (userEntity.isPresent()) {
            UserEntity user = userEntity.get();

            Optional<UserEntity> existingUser = userRepository.findByUsername(updateUserRequest.getUsername());
            if (existingUser.isPresent() && !existingUser.get().getIdentityDoc().equals(identityDoc)) {
                ApiResponse apiResponse = new ApiResponse();
                apiResponse.setMessage("El nombre de usuario ya está en uso");
                apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());

                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }

            user.setName(updateUserRequest.getName());
            user.setLastname(updateUserRequest.getLastname());
            user.setCellphone(updateUserRequest.getCellphone());
            user.setEmail(updateUserRequest.getEmail());
            user.setUsername(updateUserRequest.getUsername());
            
            
            userRepository.save(user);

            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("Usuario actualizado correctamente");
            apiResponse.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } else {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("No existe un usuario con el documento de identidad proporcionado");
            apiResponse.setStatus(HttpStatus.NOT_FOUND.value());

            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }
}
