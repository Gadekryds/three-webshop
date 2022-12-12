package dk.gadekryds.threewebshop.services.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfiguration {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
