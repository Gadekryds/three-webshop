package dk.gadekryds.threewebshop.services;

import dk.gadekryds.threewebshop.domain.data.CustomerRepository;
import dk.gadekryds.threewebshop.services.restinterfaces.JsonPlaceholderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfiguration {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
