package com.course.microservices.restfulwebservices.Users;

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
    private UserDaoService service;
    
    @Autowired
    private UserRepository repository;

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
    
    @PostMapping("/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }
}
