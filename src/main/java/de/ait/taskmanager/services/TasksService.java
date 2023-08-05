package de.ait.taskmanager.services;

import de.ait.taskmanager.dto.NewTaskDto;
import de.ait.taskmanager.dto.TaskDto;

import java.util.List;

public interface TasksService {
    TaskDto addTask(NewTaskDto taskDto);
    List<TaskDto> getAllTasks();
}
