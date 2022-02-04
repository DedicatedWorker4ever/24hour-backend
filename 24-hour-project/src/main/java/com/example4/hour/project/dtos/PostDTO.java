package com.example4.hour.project.dtos;

import com.example4.hour.project.entities.Post;
import com.example4.hour.project.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {

    int postId;
    String hashTag;
    String text;
    Date timestamp;
    User user;

    public PostDTO(Post post){
        this.hashTag = post.getHashTag();
        this.text = post.getText();
        this.timestamp = post.getTimestamp();
        this.user = post.getUser();
        this.postId = post.getPostId();
    }

    public PostDTO(String hashTag, String text, User user){
        this.hashTag = hashTag;
        this.text = text;
        this.user = user;
    }


    public static List<PostDTO> PostDTOSfromPost(Iterable<Post> posts){
        List<PostDTO> dtos = StreamSupport.stream(posts.spliterator(), false)
                .map(post -> new PostDTO(post))
                .collect(Collectors.toList());
        return dtos;
    }

    // might have to add timestamp?
    public static Post postFromPostDTO(PostDTO post){
        return new Post(post.getHashTag(),post.getText(), post.getUser());
    }

}
