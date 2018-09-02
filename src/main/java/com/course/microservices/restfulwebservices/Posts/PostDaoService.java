//package com.course.microservices.restfulwebservices.Posts;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author Mateus Costa
// */
//@Component
//public class PostDaoService {
//    private static List<Post> posts = new ArrayList<>();
//    private static int postCount = 1;
//    
//    static{
//        posts.add(new Post(1, "Oi, Dio!", 1));
//    }
//    
//    public List<Post> listAllPostsByUserId(int userId){
//        return posts.stream().filter(user -> user.getUserId().equals(userId)).collect(Collectors.toList());
//    }
//    
//    public Post save(Post post){
//        if(post.getId() == null){
//            post.setId(++postCount);
//        }
//        posts.add(post);
//        return post;
//    }
//    
//    public Post findOne(int id, int userId){
//        List<Post> posts = listAllPostsByUserId(userId);
//        return posts.stream().filter(post -> post.getId().equals(id)).findAny().orElse(null);
//    }
//}
