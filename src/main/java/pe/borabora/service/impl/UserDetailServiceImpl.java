package pe.borabora.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
import pe.borabora.dto.response.AuthenticationResponse;
import pe.borabora.entity.RoleEntity;
import pe.borabora.entity.UserEntity;
import pe.borabora.model.RoleEnum;
import pe.borabora.repository.RoleRepository;
import pe.borabora.repository.UserRepository;
import pe.borabora.util.JwtUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

        UserEntity userEntity = userRepository.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        userEntity.getRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        userEntity.getRoles().stream().flatMap(role -> role.getPermissionList().stream()).forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getPermission_name())));

        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isEnabled(), userEntity.isAccountNoExpired(), userEntity.isCredentialNoExpired(), userEntity.isAccountNoLocked(), authorityList);
    }

    public AuthenticationResponse createUser(CreateUserRequest createRoleRequest) {

    	String username = createRoleRequest.getUsername();
        String password = createRoleRequest.getPassword();
        Integer identity_doc = createRoleRequest.getIdentity_doc();
        String name = createRoleRequest.getName();
        String lastname = createRoleRequest.getLastname();
        Integer cellphone = createRoleRequest.getCellphone();
        String email = createRoleRequest.getEmail();
        
        List<String> rolesRequest = createRoleRequest.getRoleRequest().getRoleListName();

        List<RoleEnum> roles = rolesRequest.stream()
            .map(role -> RoleEnum.valueOf(role.toUpperCase()))
            .collect(Collectors.toList());

        Set<RoleEntity> roleEntityList = roleRepository.findRoleEntitiesByRoleEnumIn(roles).stream().collect(Collectors.toSet());
        if (roleEntityList.isEmpty()) {
            throw new IllegalArgumentException("El rol especificado no existe");
        }
        
        UserEntity userEntity = UserEntity.builder()
                .identity_doc(identity_doc)
                .name(name)
                .lastname(lastname)
                .cellphone(cellphone)
                .email(email)
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(roleEntityList)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();
        
        UserEntity userSaved = userRepository.save(userEntity);
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userSaved.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        userSaved.getRoles().stream().flatMap(role -> role.getPermissionList().stream()).forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getPermission_name())));

        Authentication authentication = new UsernamePasswordAuthenticationToken(userSaved, null, authorities);
        String accessToken = jwtUtils.createToken(authentication);

        AuthenticationResponse authResponse = new AuthenticationResponse(username, "User created successfully", accessToken, true);
        return authResponse;
    }

    public AuthenticationResponse loginUser(LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        AuthenticationResponse authResponse = new AuthenticationResponse(username, "Inicio de sesión exitoso", accessToken, true);
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
}
