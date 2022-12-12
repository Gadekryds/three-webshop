package dk.gadekryds.threewebshop.domain.data;

import dk.gadekryds.threewebshop.domain.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<Customer, Integer> {
}