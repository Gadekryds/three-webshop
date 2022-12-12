package dk.gadekryds.threewebshop.controllers;

import dk.gadekryds.threewebshop.domain.data.CustomerRepository;
import dk.gadekryds.threewebshop.domain.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository rep;

    public CustomerController(CustomerRepository rep) {

        this.rep = rep;
    }

    @PostMapping
    public void Post(@RequestBody Customer customer){
        rep.save(customer);
    }

    @GetMapping
    public List<Customer> Get() {
        return rep.findAll();

    }

    @GetMapping("/{id}")
    public Customer Get(@PathVariable int id){
        var customer = rep.findById(id);
        return customer.orElse(new Customer());
    }
}
