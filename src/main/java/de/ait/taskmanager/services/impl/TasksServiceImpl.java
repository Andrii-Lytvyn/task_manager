package de.ait.taskmanager.services.impl;

import de.ait.taskmanager.dto.NewTaskDto;
import de.ait.taskmanager.dto.TaskDto;
import de.ait.taskmanager.services.TasksService;
import lombok.RequiredArgsConstructor;
import de.ait.taskmanager.models.Task;
import org.springframework.stereotype.Service;
import de.ait.taskmanager.repositories.TasksRepository;

import java.util.List;

import static de.ait.taskmanager.dto.TaskDto.from;

@Service
@RequiredArgsConstructor
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;
    @Override
    public TaskDto addTask(NewTaskDto newTask) {
        Task task = Task.builder()
                .title(newTask.getTitle())
                .description(newTask.getDescription())
                .build();
        tasksRepository.save(task);
        return from(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return null;
    }

}
