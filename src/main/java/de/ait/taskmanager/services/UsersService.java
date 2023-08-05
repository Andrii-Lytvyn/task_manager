package de.ait.taskmanager.services;

import de.ait.taskmanager.dto.NewUserDto;
import de.ait.taskmanager.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    UserDto addUser(NewUserDto userDto);
}

