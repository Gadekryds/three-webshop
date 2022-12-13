package dk.gadekryds.threewebshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "dk.gadekryds.threewebshop.domain.data")
public class JpaConfig {

}