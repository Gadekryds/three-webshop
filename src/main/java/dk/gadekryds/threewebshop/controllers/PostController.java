package dk.gadekryds.threewebshop.controllers;

import dk.gadekryds.threewebshop.domain.data.PostRepository;
import dk.gadekryds.threewebshop.domain.entities.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }
}
