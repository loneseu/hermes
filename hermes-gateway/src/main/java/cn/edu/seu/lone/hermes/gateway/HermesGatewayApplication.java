package cn.edu.seu.lone.hermes.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HermesGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HermesGatewayApplication.class, args);
    }
}
