package com.course.microservices.restfulwebservices.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mateus Costa
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
