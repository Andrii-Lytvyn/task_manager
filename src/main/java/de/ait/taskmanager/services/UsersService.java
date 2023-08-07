package de.ait.taskmanager.services;

import de.ait.taskmanager.dto.*;

import java.util.List;

public interface UsersService {
    UsersDto getAllUsers();

    UserDto addUser(NewUserDto newUser);

    UserDto getUser(Long userId);

    TasksDto getTasksOfUser(Long userId);

}

