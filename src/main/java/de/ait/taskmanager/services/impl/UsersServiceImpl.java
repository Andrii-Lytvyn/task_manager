package de.ait.taskmanager.services.impl;

import de.ait.taskmanager.dto.NewUserDto;
import de.ait.taskmanager.dto.UserDto;
import de.ait.taskmanager.exceptions.NotFoundException;
import de.ait.taskmanager.services.UsersService;
import lombok.RequiredArgsConstructor;
import de.ait.taskmanager.models.User;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import de.ait.taskmanager.repositories.UsersRepository;
import de.ait.taskmanager.dto.TasksDto;
import de.ait.taskmanager.dto.UsersDto;
import java.util.List;

import static de.ait.taskmanager.dto.UserDto.from;
import static de.ait.taskmanager.dto.TaskDto.from;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;


    @Override
    public UsersDto getAllUsers() {
        List<User> users = usersRepository.findAll();
        return UsersDto.builder()
                .users(from(users))
                .count(users.size())
                .build();
    }

    @Override
    public UserDto addUser(NewUserDto userDto) {

        User user = User.builder()
                .loginName(userDto.getLoginName())
                .build();

        usersRepository.save(user);

        return from(user);
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User with id <" + userId + "> not found"));
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    @Override
    public TasksDto getTasksOfUser(Long userId) {
        User user = getUserOrThrow(userId);

        return TasksDto.builder()
                .tasks(from(user.getTasks()))
                .count(user.getTasks().size())
                .build();
    }


}
