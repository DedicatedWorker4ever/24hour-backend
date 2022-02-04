package com.example4.hour.project.configuration;

import com.example4.hour.project.entities.Post;
import com.example4.hour.project.entities.User;
import com.example4.hour.project.repository.PostRepository;
import com.example4.hour.project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DataSetup implements CommandLineRunner {

    PostRepository postRepository;
    UserRepository userRepository;

    public DataSetup(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("SamSon", "I'm a cool guy who's into memes");
        User user2 = new User("SamFar", "Being cool is just in my blood");
        User user3 = new User("Sam", "I'm the origin of everything cool");
        User user4 = new User("SamsSonsSon","Being young never stopped me from being cool");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);


        Post post1 = new Post("#Cool #Style", "Are hats still cool and in fashion?", user1);
        Post post2 = new Post("#Cool #Games #myMom", "Is playing minesweaper with my mom cool?", user4);
        Post post3 = new Post("#Cool #Politics", "Is it just me or is Joe Biden kinda sexy", user2);
        Post post4 = new Post("#Art #Nature", "Check out this picture I'm imagening right now. Image pending", user3);
        Post post5 = new Post("#Cool #Books #Style", "Is reading books while wearing a har still in style?", user3);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
    }
}
