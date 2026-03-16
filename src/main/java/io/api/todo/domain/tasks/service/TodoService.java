package io.api.todo.domain.tasks.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.api.todo.domain.tasks.entity.Todo;
import io.api.todo.domain.tasks.repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodo(UUID id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo updateTodo(UUID id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        if (existingTodo != null) {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDescription(todo.getDescription());
            existingTodo.setCompleted(todo.isCompleted());
            return todoRepository.save(existingTodo);
        }
        return null;
    }

    public void deleteTodo(UUID id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}