package de.ait.taskmanager.controllers.api;

import de.ait.taskmanager.dto.NewUserDto;
import de.ait.taskmanager.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/users")
public interface UsersApi {
    @GetMapping
    List<UserDto> getAllUsers();

    @PostMapping
    UserDto addUser(@RequestBody NewUserDto userDto);
}
