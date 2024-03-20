package pe.borabora.service.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import pe.borabora.dto.CreateUser;
import pe.borabora.entity.UserEntity;
import pe.borabora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    
    //este servicio se utiliza para cargar los detalles de un usuario de la base de datos 
    //y convertirlos en un objeto User de Spring Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        Collection<? extends GrantedAuthority> authorities = userEntity.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                .collect(Collectors.toSet());

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }

    public UserEntity getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Actualizar los detalles de un usuario
    public void updateUserDetails(UserEntity userEntity, CreateUser userDetails) {
        userDetails.setIdentity_doc(userDetails.getIdentity_doc());
        userEntity.setName(userDetails.getName());
        userEntity.setLastname(userDetails.getLastname());
        userEntity.setEmail(userDetails.getEmail());
        userEntity.setCellphone(userDetails.getCellphone());
        // No actualizas los roles aquí
        userRepository.save(userEntity);
    }
}
