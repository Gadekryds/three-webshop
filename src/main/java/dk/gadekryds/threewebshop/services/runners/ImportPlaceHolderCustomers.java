package dk.gadekryds.threewebshop.services.runners;

import dk.gadekryds.threewebshop.domain.data.AddressRepository;
import dk.gadekryds.threewebshop.domain.data.CustomerRepository;
import dk.gadekryds.threewebshop.domain.entities.Address;
import dk.gadekryds.threewebshop.domain.entities.Post;
import dk.gadekryds.threewebshop.domain.entities.PostComment;
import dk.gadekryds.threewebshop.services.JsonPlaceholderService;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ImportPlaceHolderCustomers {

    @Bean
    CommandLineRunner setupPosts() {
        return args -> {

        };

    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository, AddressRepository addressRepository) {
        return args -> {
            WebClient client = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
            HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
            JsonPlaceholderService jps = factory.createClient(JsonPlaceholderService.class);

            var customers = jps.loadCustomers();
            customerRepository.saveAll(customers);

        };
    }
    //@Bean
    //CommandLineRunner postSetup(EntityManager entityManager) {
    //    return args -> {
//
    //        Post post1 = new Post();
    //        post1.getComments().add(new PostComment("First..."));
    //        post1.getComments().add(new PostComment("Second..."));
//
    //        entityManager.persist(post1);
    //    };
    //}
    //@Bean
    //CommandLineRunner restClientCommandLineRunner(CustomerRepository customerRepository, CustomerService customerService){
    //	return args ->  {
    //		var customers = customerService.loadCustomers();
    //        customers.get(0).setId(11);
    //		customerRepository.saveAll(customers);
    //	};
    //}
}
