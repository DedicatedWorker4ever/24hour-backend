package com.example4.hour.project.repository;

import com.example4.hour.project.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    @Query(value = "SELECT * FROM post WHERE user_id = ?1",
            nativeQuery = true)
    List<Post> findPostByUser(int userId);

    @Query(value = "SELECT * FROM post WHERE hash_tag LIKE %?%",
            nativeQuery = true)
    List<Post> findPostByHashTag(String hashTag);
}
