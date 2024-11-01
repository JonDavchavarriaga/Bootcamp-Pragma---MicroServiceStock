package com.microservicestock.application.Jwt;

import com.microservicestock.domain.user.entity.RoleEnum;
import com.microservicestock.domain.user.entity.UserEntity;
import com.microservicestock.domain.user.repository.UserRepository;
import com.microservicestock.application.Security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailService;
    //password encoder
    @Autowired
    private final PasswordEncoder passwordEncoder;


    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        // Si la autenticación no es válida, retorna un 403
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Authentication failed");
        }

        // Si la autenticación fue exitosa, genera el token
        String token = jwtService.getToken(userDetailService.loadUserByUsername(request.getEmail()));

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        String password = passwordEncoder.encode(request.getPassword());
        UserEntity user = UserEntity.builder().
                name(request.getName()).
                lastName(request.getLastName()).
                email(request.getEmail()).
                password(password).
                role(RoleEnum.USER).
                build();

        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
