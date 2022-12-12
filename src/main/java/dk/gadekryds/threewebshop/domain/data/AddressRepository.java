package dk.gadekryds.threewebshop.domain.data;

import dk.gadekryds.threewebshop.domain.entities.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepository extends ListCrudRepository<Address, Integer> {

}