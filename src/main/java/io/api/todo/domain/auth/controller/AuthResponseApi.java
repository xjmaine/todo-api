package io.api.todo.domain.auth.controller;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseApi{
    private String email;
    private List<String> roles;
    private String message;
    
}