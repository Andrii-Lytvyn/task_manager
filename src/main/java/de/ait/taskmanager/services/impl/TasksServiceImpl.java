package de.ait.taskmanager.services.impl;

import de.ait.taskmanager.dto.NewTaskDto;
import de.ait.taskmanager.dto.TaskDto;
import de.ait.taskmanager.exceptions.IncorrectUserIdException;
import de.ait.taskmanager.models.User;
import de.ait.taskmanager.repositories.UsersRepository;
import de.ait.taskmanager.services.TasksService;
import lombok.RequiredArgsConstructor;
import de.ait.taskmanager.models.Task;
import org.springframework.stereotype.Service;
import de.ait.taskmanager.repositories.TasksRepository;

import java.time.LocalDate;
import java.util.List;

import static de.ait.taskmanager.dto.TaskDto.from;

@Service
@RequiredArgsConstructor
public class TasksServiceImpl implements TasksService {

    private final UsersRepository usersRepository;
    private final TasksRepository tasksRepository;

    @Override
    public TaskDto addTask(NewTaskDto newTask) {
        User user = usersRepository.findById(newTask.getAboutUserId()).orElseThrow(() ->
                new IncorrectUserIdException("Id <" + newTask.getAboutUserId() + "> is not correct"));
        Task task = Task.builder()
                .title(newTask.getTitle())
                .executor(user)
                .startDate(LocalDate.parse(newTask.getPublishDate()))
                .build();
        tasksRepository.save(task);
        return from(task);

    }
}



