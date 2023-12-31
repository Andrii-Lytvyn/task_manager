package de.ait.taskmanager.services;

import de.ait.taskmanager.dto.*;

import java.util.List;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers(Integer pageNumber, String orderByField, Boolean desc, String filterBy, String filterValue);

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);

    TasksDto getTasksOfUser(Long userId);

}

