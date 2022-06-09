package me.chdm.springbootwithdockerdemo;

import me.chdm.springbootwithdockerdemo.model.User;
import me.chdm.springbootwithdockerdemo.model.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWithDockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithDockerDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(UserRepository repository) {
        return args -> {
            repository.save(new User("Dima", 38));
            repository.save(new User("Tima", 9));
        };
    }
}
