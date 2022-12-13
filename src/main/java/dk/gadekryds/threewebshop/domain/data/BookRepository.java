package dk.gadekryds.threewebshop.domain.data;

import dk.gadekryds.threewebshop.domain.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BookRepository extends CrudRepository<Book, Serializable> {
}
