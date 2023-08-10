package de.ait.taskmanager.controllers;

import de.ait.taskmanager.controllers.api.TasksApi;
import de.ait.taskmanager.dto.NewTaskDto;
import de.ait.taskmanager.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import de.ait.taskmanager.services.TasksService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TasksController implements TasksApi {
    private final TasksService tasksService;

    @Override
    public ResponseEntity<TaskDto> addTask(NewTaskDto newTask) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tasksService.addTask(newTask));
    }




}
