package de.ait.taskmanager.controllers;

import de.ait.taskmanager.controllers.api.UsersApi;
import de.ait.taskmanager.dto.NewUserDto;
import de.ait.taskmanager.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import de.ait.taskmanager.services.UsersService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {
    private final UsersService usersService;

    @Override
    public List<UserDto> getAllUsers() {
        return usersService.getAllUsers();
    }

    @Override
    public UserDto addUser(NewUserDto userDto) {
        return usersService.addUser(userDto);
    }
}


