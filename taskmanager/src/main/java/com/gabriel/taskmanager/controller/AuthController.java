package com.gabriel.taskmanager.controller;

import com.gabriel.taskmanager.controller.dto.AuthRequest;
import com.gabriel.taskmanager.controller.dto.AuthResponse;
import com.gabriel.taskmanager.controller.dto.RegisterRequest;
import com.gabriel.taskmanager.domain.User;
import com.gabriel.taskmanager.repository.UserRepository;
import com.gabriel.taskmanager.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    // 🔹 Registro de usuário
    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest req) {
        // Cria o usuário no banco
        User u = User.builder()
                .username(req.username())
                .email(req.email())
                .password(passwordEncoder.encode(req.password()))
                .role(User.Role.USER)
                .build();

        userRepo.save(u);

        // Gera token JWT
        String token = jwtService.generateToken(u.getUsername());
        return new AuthResponse(token);
    }

    // 🔹 Login
    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody AuthRequest req) {
        // Autentica credenciais
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.username(), req.password())
        );

        // Busca usuário e gera token
        User u = userRepo.findByUsername(req.username())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String token = jwtService.generateToken(u.getUsername());
        return new AuthResponse(token);
    }
}
