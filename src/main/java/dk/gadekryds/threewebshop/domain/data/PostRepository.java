package dk.gadekryds.threewebshop.domain.data;

import dk.gadekryds.threewebshop.domain.entities.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}