package com.course.microservices.restfulwebservices.Users;

import com.course.microservices.restfulwebservices.Posts.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author Mateus Costa
 */
@ApiModel(description = "All details about the user.")
@Entity
public class User {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Size(min=2, message="Name should have at least 2 charecters")
    @ApiModelProperty(notes="Name should have at least 2 characters")
    private String name;
    
    @Past(message = "Birth Date should be in the past")
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date birthDate;
    
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    protected User() {
    }
    
    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    @Override
    public String toString(){
        return String.format("User [id=%s, name=%s, birthDate=%s", id, name, birthDate);
    }
}
