package dk.gadekryds.threewebshop.services.runners;

import dk.gadekryds.threewebshop.domain.data.AddressRepository;
import dk.gadekryds.threewebshop.domain.data.CustomerRepository;
import dk.gadekryds.threewebshop.domain.entities.Address;
import dk.gadekryds.threewebshop.services.JsonPlaceholderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ImportPlaceHolderCustomers {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository, AddressRepository addressRepository) {
        return args -> {
            WebClient client = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
            HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
            JsonPlaceholderService jps = factory.createClient(JsonPlaceholderService.class);

            Address address1 = new Address();
            address1.setStreetName("Højsletten");
            address1.setStreetNo(9);


            Address address2 = new Address();
            address1.setStreetName("Svaneparken");
            address1.setStreetNo(66);

            addressRepository.save(address1);
            addressRepository.save(address2);

            var customers = jps.loadCustomers();

            int id = 0;
            for(var customer : customers){
                if(id++ % 2 == 0){
                    customer.setAddress(address1);
                }
                else {
                    customer.setAddress(address2);
                }
            }

            customerRepository.saveAll(customers);

        };
    }

    //@Bean
    //CommandLineRunner restClientCommandLineRunner(CustomerRepository customerRepository, CustomerService customerService){
    //	return args ->  {
    //		var customers = customerService.loadCustomers();
    //        customers.get(0).setId(11);
    //		customerRepository.saveAll(customers);
    //	};
    //}
}
