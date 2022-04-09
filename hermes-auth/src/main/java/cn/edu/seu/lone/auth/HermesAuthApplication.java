package cn.edu.seu.lone.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("cn.edu.seu.lone")
@ComponentScan("cn.edu.seu.lone")
@EntityScan("cn.edu.seu.lone")
@EnableCaching
public class HermesAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(HermesAuthApplication.class, args);
    }
}
