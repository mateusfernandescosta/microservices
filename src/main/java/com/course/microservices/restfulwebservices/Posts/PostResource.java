package com.course.microservices.restfulwebservices.Posts;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Mateus Costa
 */
@RestController
public class PostResource {
    
    @Autowired
    PostDaoService service;
    
    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPostByUser(@PathVariable int userId){
        return service.listAllPostsByUserId(userId);
    }
    
    @GetMapping("users/{userId}/posts/{id}")
    public Post retrievePost(@PathVariable int userId, @PathVariable int id){
        return service.findOne(id, userId);
    }
    
    @PostMapping("/users/{userId}/posts")
    public ResponseEntity createPost(@RequestBody Post post, @PathVariable int userId){
        post.setUserId(userId);
        Post savedPost = service.save(post);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
}
