package com.example4.hour.project.rest;

import com.example4.hour.project.dtos.PostDTO;
import com.example4.hour.project.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    PostService postService;
    public PostController(PostService postService){this.postService = postService;}

    @GetMapping("/getPosts")
    @ResponseBody
    List<PostDTO> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/getPostById/{postId}")
    PostDTO getPost(@PathVariable int postId) {

        return postService.getPost(postId);
    }

    @PostMapping("/addPost")
    PostDTO addPost(@RequestBody PostDTO newPost) {
        return postService.addPost(newPost);
    }

    @PutMapping(value = "/editPost/{postId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    PostDTO editPost(@RequestBody PostDTO postToEdit, @PathVariable int postId ) throws Exception {
        return postService.editPost(postToEdit,postId);
    }

    @DeleteMapping("/deletePost/{postId}")
    void deletePost(@PathVariable int postId){
        postService.deletePost(postId);

    }

    @GetMapping("/getPosts/{userId}")
    @ResponseBody
    List<PostDTO> getPostByUserId (@PathVariable int userId){
        return postService.getPostByUserId(userId);
    }

    @GetMapping("/getPostsByHashTag/{hashTag}")
    @ResponseBody
    List<PostDTO> getPostByHashTag (@PathVariable String hashTag){
        return postService.getPostByHashTag(hashTag);
    }
}
