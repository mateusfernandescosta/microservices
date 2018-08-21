package com.course.microservices.restfulwebservices.Users;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author Mateus Costa
 */
@ApiModel(description = "All details about the user.")
public class User {
    
    private Integer id;
    
    @Size(min=2, message="Name should have at least 2 charecters")
    @ApiModelProperty(notes="Name should have at least 2 characters")
    private String name;
    
    @Past(message = "Birth Date should be in the past")
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date birthDate;

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
    
    
}
