package de.ait.taskmanager.controllers;

import de.ait.taskmanager.controllers.api.TasksApi;
import de.ait.taskmanager.dto.NewTaskDto;
import de.ait.taskmanager.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import de.ait.taskmanager.services.TasksService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TaskController implements TasksApi {
    private final TasksService tasksService;

    @Override
    public TaskDto addTask(NewTaskDto newTask){
        return tasksService.addTask(newTask);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return tasksService.getAllTasks();
    }
}
