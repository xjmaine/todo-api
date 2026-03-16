package io.api.todo.domain.auth.services;

import java.time.LocalDateTime;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.api.todo.domain.identity.entity.User;
import io.api.todo.domain.identity.repository.UserRepositoy;
import io.api.todo.global.config.auth.AuthUserPrincipal;
import io.api.todo.global.utils.StringConstants;

@Service
public class AuthUserDetailsService implements UserDetailsService {
    private final UserRepositoy userRepository;

    public AuthUserDetailsService(UserRepositoy userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(StringConstants.USER_NOT_FOUND + "with email: " + email));

        return new AuthUserPrincipal(user);
    }

}
