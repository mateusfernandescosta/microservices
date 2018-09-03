package com.course.microservices.restfulwebservices.Posts;

import com.course.microservices.restfulwebservices.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mateus Costa
 */
@Entity
public class Post {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private User user;

    protected Post() {
    }
    
    public Post(Integer id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString(){
        return String.format("Post [id=%s, description=%s]", id, description);
    }
    
}
