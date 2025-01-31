package com.project.CustomSystemBack.Controller;

import com.project.CustomSystemBack.Configuration.JwtUtils;
import com.project.CustomSystemBack.Model.DAO.UsersDao;
import com.project.CustomSystemBack.Model.DTO.LoginDto;
import com.project.CustomSystemBack.Repository.UsersRepository;
import com.project.CustomSystemBack.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;
    private final UsersRepository usersRepository;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, PasswordEncoder passwordEncoder, CustomUserDetailsService customUserDetailsService
    ,UsersRepository usersRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.customUserDetailsService = customUserDetailsService;
        this.usersRepository = usersRepository;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> authenticateUser(@RequestBody LoginDto loginDto) {
        System.out.println("DATOS RECIBIDOS: " + loginDto);
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("INGREANDO AL TRY");
            autenticar(loginDto.getUsername(), loginDto.getPassword());

            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(loginDto.getUsername());

            System.out.println("USER DETAILS DEL CONTROLLER: " + userDetails.toString());
            String jwt = jwtUtils.generateToken(userDetails);

            response.put("success", true);
            response.put("message", "Inicio de sesión exitoso");
            response.put("token", jwt);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Contraseña incorrecta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    private void autenticar(String username, String password) throws Exception {
        UsersDao user = usersRepository.findByUsername(username);

        if (user != null) {
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new BadCredentialsException("Credenciales inválidas");
            }
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

}
