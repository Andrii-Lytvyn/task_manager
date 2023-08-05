package de.ait.taskmanager.controllers.api;

import de.ait.taskmanager.dto.TaskDto;
import de.ait.taskmanager.dto.NewTaskDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/tasks")
public interface TasksApi {
    @PostMapping
    TaskDto addTask(@RequestBody NewTaskDto newTask);

    @GetMapping
    List<TaskDto> getAllTasks();
}
