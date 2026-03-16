package io.api.todo.domain.tasks.entity;

import java.time.LocalDateTime;

import io.api.todo.domain.identity.entity.BaseModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends BaseModel{
   

    private String title;
    private String description;
    private boolean completed;

}