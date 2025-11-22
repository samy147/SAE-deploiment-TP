package com.uspn.H2Demo;

import com.uspn.H2Demo.entities.Adherent;
import com.uspn.H2Demo.repository.AdherentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class H2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(H2DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AdherentRepository repository) {
        return args -> {
            repository.save(new Adherent(null, "A", "B", 29));
            repository.save(new Adherent(null, "A", "B", 29));
            repository.save(new Adherent(null, "A", "B", 29));
            repository.save(new Adherent(null, "A", "B", 29));
        };
    }
}