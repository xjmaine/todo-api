package io.api.todo.global.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.api.todo.domain.identity.entity.Role;
import io.api.todo.domain.identity.entity.User;
import io.api.todo.domain.identity.repository.UserRepositoy;

@Configuration
public class DataSeeder {

    private final UserRepositoy userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepositoy userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initData(){
        return args -> {
            seedData();
        };
    }


    public void seedData() {
        if(userRepository.findByEmail("super_admin@todo.com").isEmpty()){
            User user = new User();
            user.setEmail("super_admin@todo.com");
            user.setUsername("super_admin");
            user.setPassword(passwordEncoder.encode("BlueSkies@2026!"));
            user.setRole(Role.SUPER_ADMIN);
            user.setActive(true);
            user.setDeleted(false);
            userRepository.save(user);

            //log scess, email and password
            System.out.println("Super admin created successfully");
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password: " + user.getPassword() + " :or: "+ "BlueSkies@2026!");
        }
    }
    
}
