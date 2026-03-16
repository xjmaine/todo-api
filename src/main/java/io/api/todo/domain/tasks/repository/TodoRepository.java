package io.api.todo.domain.tasks.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.api.todo.domain.tasks.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
    
}