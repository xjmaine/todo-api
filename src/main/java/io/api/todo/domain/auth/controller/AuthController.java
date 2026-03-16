package io.api.todo.domain.auth.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.api.todo.global.utils.StringConstants;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public AuthResponseApi login(@Valid @RequestBody AuthRequestApi authRequestApi) {
       UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authRequestApi.getEmail(), authRequestApi.getPassword());
         Authentication authentication = authenticationManager.authenticate(authToken);
         
        List<String> roles = authentication.getAuthorities()
        .stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());
        return AuthResponseApi.builder()
                .email(authRequestApi.getEmail())
                .roles(roles)
                .message(StringConstants.LOGIN_SUCCESS)
                .build();
    }

    @PostMapping("/register")
    public AuthResponseApi register(@Valid @RequestBody AuthRequestApi authRequestApi) {
        return AuthResponseApi.builder()
                .email(authRequestApi.getEmail())
                .roles(List.of("ROLE_USER"))
                .message(StringConstants.USER_CREATED)
                .build();
    }
}