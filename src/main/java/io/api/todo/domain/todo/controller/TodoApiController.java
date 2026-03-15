package io.api.todo.domain.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoApiController {

    @GetMapping("/login")  // http://localhost:8090/api/v1/todos/login
    public String getLogin(){
        //json response 
        return HttpServletResponse.ok("login");
    }
    
}
