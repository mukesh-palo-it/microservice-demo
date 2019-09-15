package com.ntuc.income.api;

import com.ntuc.income.api.dto.UserDto;
import com.ntuc.income.entity.User;
import com.ntuc.income.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public Long createUsers(@RequestBody UserDto userDto){
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        return userRepository.save(user).getUserId();
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).get();
        return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
