package dk.gadekryds.threewebshop;

import dk.gadekryds.threewebshop.domain.data.CustomerRepository;
import dk.gadekryds.threewebshop.services.CustomerService;
import dk.gadekryds.threewebshop.services.restinterfaces.JsonPlaceholderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class ThreeWebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreeWebshopApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			WebClient client = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
			HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
			JsonPlaceholderService jps = factory.createClient(JsonPlaceholderService.class);

			var customers = jps.loadCustomers();
			customerRepository.saveAll(customers);
		};
	}

	//@Bean
	//CommandLineRunner restClientCommandLineRunner(CustomerRepository customerRepository, CustomerService customerService){
	//	return args ->  {
	//		var customers = customerService.loadCustomers();
	//		customerRepository.saveAll(customers);
	//	};
	//}

}
