package io.api.todo.domain.auth.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequestApi {
    @NotBlank(message = "Email cannot be empty")
    private String email;
    
    @NotBlank(message = "Password cannot be empty")
    private String password;
}