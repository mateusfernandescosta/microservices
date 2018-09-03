package com.course.microservices.restfulwebservices.Users;

import com.course.microservices.restfulwebservices.Posts.Post;
import com.course.microservices.restfulwebservices.Posts.PostRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class UserJPAResource {
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }
    
    @GetMapping("/jpa/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        
        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        
        //link to resource to get all Users
        Resource<User> resource = new Resource<>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        
        return resource;
    }
    
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllPostsFromUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        
        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        
        return user.get().getPosts();
    }
    
    @GetMapping("/jpa/users/{id}/posts/{postid}")
    public Resource<Post> retrievePostById(@PathVariable int id, @PathVariable int postid){
        Optional<Post> post = postRepository.findById(postid);
        
        if(!post.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        if(post.get().getUser().getId() != id){
            throw new UserNotFoundException("id-"+id);
        }
        
        //link to resource to get all Users
        Resource<Post> resource = new Resource<>(post.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllPostsFromUser(id));
        resource.add(linkTo.withRel("all-posts"));
        
        return resource;
    }
    
    @PostMapping("/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        
        return ResponseEntity.created(location).build();
    }
    
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity createPost(@PathVariable int id, @RequestBody Post post){
        Optional<User> user = repository.findById(id);
        
        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        
        post.setUser(user.get());
        
        Post savedPost = postRepository.save(post);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }
}
