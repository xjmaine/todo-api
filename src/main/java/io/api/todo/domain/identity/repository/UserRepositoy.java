package io.api.todo.domain.identity.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.api.todo.domain.identity.entity.User;

@Repository
public interface UserRepositoy extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
