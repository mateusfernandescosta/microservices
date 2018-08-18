package com.course.microservices.restfulwebservices.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mateus Costa
 */
@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;
    
    static {
        users.add(new User(1, "Mateus Costa", new Date()));
        users.add(new User(2, "Diovana Magalhães", new Date()));
        users.add(new User(3, "José San Pedro", new Date()));
    }
    
    public List<User> findAll(){
        return users;
    }
    
    public User save(User user){
        if (user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }
    
    public User findOne(int id){
        for(User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }
    
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
