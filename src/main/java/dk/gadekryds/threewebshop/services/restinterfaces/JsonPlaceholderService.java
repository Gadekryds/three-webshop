package dk.gadekryds.threewebshop.services.restinterfaces;

import dk.gadekryds.threewebshop.domain.entities.Customer;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface JsonPlaceholderService {

    @GetExchange("/users")
    List<Customer> loadCustomers();
}
