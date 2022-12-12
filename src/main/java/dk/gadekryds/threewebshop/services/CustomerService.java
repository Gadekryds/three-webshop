package dk.gadekryds.threewebshop.services;

import dk.gadekryds.threewebshop.domain.entities.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {
    private final RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Customer> loadCustomers() {
        // use httpClient to get data.
        var exchange = restTemplate.exchange("https://jsonplaceholder.typicode.com/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {
                });
        return exchange.getBody();
    }
}
