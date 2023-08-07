package de.ait.taskmanager.controllers;

import de.ait.taskmanager.controllers.api.UsersApi;
import de.ait.taskmanager.dto.NewUserDto;
import de.ait.taskmanager.dto.TasksDto;
import de.ait.taskmanager.dto.UserDto;
import de.ait.taskmanager.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import de.ait.taskmanager.services.UsersService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {
    private final UsersService usersService;

    @Override
    public ResponseEntity<UsersDto> getAllUsers() {
        return ResponseEntity
                .ok(usersService.getAllUsers());
    }
    @Override
    public ResponseEntity<UserDto> addUser(NewUserDto userDto) {
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.addUser(userDto));
    }
    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity
                .ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<TasksDto> getTasksOfUser(Long userId) {
        return ResponseEntity
                .ok(usersService.getTasksOfUser(userId));
    }



}


