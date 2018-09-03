package com.course.microservices.restfulwebservices.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mateus Costa
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
    
}
