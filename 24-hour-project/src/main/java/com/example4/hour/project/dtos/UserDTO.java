package com.example4.hour.project.dtos;

import com.example4.hour.project.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    int userId;
    String username;
    String description;


    public UserDTO(User user){
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.description = user.getDescription();
    }

    public UserDTO(String username, String description){
        this.username = username;
        this.description = description;
    }

    public static List<UserDTO> uesrDTOSfromUser(Iterable<User> users){
        List<UserDTO> dtos = StreamSupport.stream(users.spliterator(), false)
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());
        return dtos;
    }

    public static User userFromUserDTO(UserDTO user){
        return new User(user.getUsername(),user.getDescription());
    }


}
