package com.example4.hour.project.rest;

import com.example4.hour.project.dtos.PostDTO;
import com.example4.hour.project.dtos.UserDTO;
import com.example4.hour.project.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService){this.userService = userService; }

    @PostMapping("/addUser")
    UserDTO addUser(@RequestBody UserDTO newUser) {
        return userService.addUser(newUser);
    }

    @GetMapping("/get-all")
    @ResponseBody
    List<UserDTO> getUsers() {
        return userService.getUsers();
    }
}
