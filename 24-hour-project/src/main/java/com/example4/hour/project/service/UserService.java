package com.example4.hour.project.service;

import com.example4.hour.project.dtos.PostDTO;
import com.example4.hour.project.dtos.UserDTO;
import com.example4.hour.project.entities.Post;
import com.example4.hour.project.entities.User;
import com.example4.hour.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){ this.userRepository = userRepository;}

    public List<UserDTO> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return UserDTO.uesrDTOSfromUser(users);
    }

    public UserDTO addUser(UserDTO newUser){
        User userCreation = UserDTO.userFromUserDTO(newUser);
        //if(userRepository.findByUsername(userCreation.getUsername()) != null){
        return new UserDTO(userRepository.save(userCreation));
    }


}
