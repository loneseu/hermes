package cn.edu.seu.lone.hermes.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("cn.edu.seu.lone")
@ComponentScan("cn.edu.seu.lone")
@EntityScan("cn.edu.seu.lone")
public class HermesApplication {
    public static void main(String[] args) {
        SpringApplication.run(HermesApplication.class, args);
    }
}
