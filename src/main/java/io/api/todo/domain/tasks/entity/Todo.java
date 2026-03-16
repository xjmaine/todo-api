package io.api.todo.domain.tasks.entity;

import java.time.LocalDateTime;

import io.api.todo.domain.identity.entity.BaseModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "todos")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
public class Todo extends BaseModel{
   

    private String title;
    private String description; 
    private boolean completed;

    public Todo() {
    }

    public Todo(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }   

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}