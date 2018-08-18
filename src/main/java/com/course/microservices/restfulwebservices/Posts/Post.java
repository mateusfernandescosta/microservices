package com.course.microservices.restfulwebservices.Posts;

/**
 *
 * @author Mateus Costa
 */
public class Post {
    private Integer id;
    private String message;
    private Integer userId;

    protected Post() {
    }
    
    public Post(Integer id, String message, Integer userId) {
        this.id = id;
        this.message = message;
        this.userId = userId;
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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
}
