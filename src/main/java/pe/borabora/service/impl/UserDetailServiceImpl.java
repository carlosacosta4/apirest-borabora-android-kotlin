package pe.borabora.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.borabora.dto.request.CreateUserRequest;
import pe.borabora.dto.request.LoginRequest;
import pe.borabora.dto.request.PasswordUpdateRequest;
import pe.borabora.dto.response.ApiResponse;
import pe.borabora.dto.response.AuthenticationResponse;
import pe.borabora.entity.RoleEntity;
import pe.borabora.entity.UserEntity;
import pe.borabora.model.RoleEnum;
import pe.borabora.repository.RoleRepository;
import pe.borabora.repository.UserRepository;
import pe.borabora.util.JwtUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

    	UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        userEntity.getRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        
        return new User(userEntity.getUsername(), userEntity.getPassword(), true, true, true, true, authorityList);
    }

    public AuthenticationResponse createUser(CreateUserRequest createUserRequest) {

    	String username = createUserRequest.getUsername();
        String password = createUserRequest.getPassword();
        Integer identity_doc = createUserRequest.getIdentity_doc();
        String name = createUserRequest.getName();
        String lastname = createUserRequest.getLastname();
        Integer cellphone = createUserRequest.getCellphone();
        String email = createUserRequest.getEmail();

        //esto es para pasarle el rol
        /*List<String> rolesRequest = createUserRequest.getRoleRequest().getRoleListName();

        List<RoleEnum> roleEnums = rolesRequest.stream()
            .map(role -> RoleEnum.valueOf(role.toUpperCase()))
            .collect(Collectors.toList());

        Set<RoleEntity> roleEntityList = roleRepository.findRoleEntitiesByRoleEnumIn(roleEnums).stream().collect(Collectors.toSet());
        if (roleEntityList.isEmpty()) {
            throw new IllegalArgumentException("El rol especificado no existe");
        }*/

        // Find the "user" role
        RoleEntity userRole = roleRepository.findByRoleEnum(RoleEnum.USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

        // asignar user por defecto a cada usuario creado
        Set<RoleEntity> roleEntityList = new HashSet<>();
        roleEntityList.add(userRole);


        UserEntity userEntity = UserEntity.builder()
                .identityDoc(identity_doc)
                .name(name)
                .lastname(lastname)
                .cellphone(cellphone)
                .email(email)
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(roleEntityList)  //.roles(roleEntityList)
                .build();
        
        UserEntity userSaved = userRepository.save(userEntity);
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userSaved.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(userSaved, null, authorities);
        String accessToken = jwtUtils.createToken(authentication);

        AuthenticationResponse authResponse = new AuthenticationResponse(username, "Usuario creado exitosamente", accessToken, true, roles, identity_doc);
        return authResponse;
    }

    public AuthenticationResponse loginUser(LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        // Obtener identityDoc del UserEntity
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));
        Integer identityDoc = userEntity.getIdentityDoc();

        AuthenticationResponse authResponse = new AuthenticationResponse(username, "Inicio de sesión exitoso", accessToken, true, roles, identityDoc);
        return authResponse;
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException(String.format("Usuario o contraseña inválida"));
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Contraseña inválida");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }

  //actualizar contraseña
    public ApiResponse updatePassword(PasswordUpdateRequest request) {
        Optional<UserEntity> userOptional = userRepository.findByEmailAndCellphoneAndIdentityDoc(request.getEmail(), request.getCellphone(), request.getIdentityDoc());
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userRepository.save(user);
            return new ApiResponse("Contraseña actualizada con exito", 200);
        } else {
            return new ApiResponse("User no encontrado", 404);
        }
    }
}
