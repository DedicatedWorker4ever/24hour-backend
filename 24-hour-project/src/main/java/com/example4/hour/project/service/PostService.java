package com.example4.hour.project.service;

import com.example4.hour.project.dtos.PostDTO;
import com.example4.hour.project.entities.Post;
import com.example4.hour.project.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<PostDTO> getPosts() {
        Iterable<Post> posts = postRepository.findAll();
        return PostDTO.PostDTOSfromPost(posts);
    }

    public PostDTO getPost(int postId) {

        Post post = postRepository.findById(postId).orElseThrow();
        return new PostDTO(post);
    }

    public PostDTO addPost(PostDTO newPost){
        Post postCreation = PostDTO.postFromPostDTO(newPost);
        return new PostDTO(postRepository.save(postCreation));
    }

    public PostDTO editPost(PostDTO postToEdit, int postId){
        Post postRemade = postRepository.findById(postId).orElseThrow();
        postRemade.setHashTag(postToEdit.getHashTag());
        postRemade.setText(postToEdit.getText());
        return new PostDTO(postRepository.save(postRemade));
    }

    public void deletePost(int postId){
        postRepository.deleteById(postId);
    }

    public List<PostDTO> getPostByUserId (int userId){
        return PostDTO.PostDTOSfromPost(postRepository.findPostByUser(userId));
    }

    public List<PostDTO> getPostByHashTag (String hashTag){
        return PostDTO.PostDTOSfromPost(postRepository.findPostByHashTag(hashTag));
    }


}
