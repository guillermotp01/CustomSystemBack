package com.project.CustomSystemBack.Service;

import com.project.CustomSystemBack.Model.DAO.UsersDao;
import com.project.CustomSystemBack.Repository.UsersRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    public CustomUserDetailsService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersDao userEntity = userRepository.findByUsername(username);
        System.out.println("USUARIO BUSCADO EN CUSTOM:" + userEntity);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ADMIN"));

        return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }

}

