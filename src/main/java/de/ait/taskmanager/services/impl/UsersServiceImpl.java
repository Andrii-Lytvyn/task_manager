package de.ait.taskmanager.services.impl;

import de.ait.taskmanager.dto.NewUserDto;
import de.ait.taskmanager.dto.UserDto;
import de.ait.taskmanager.services.UsersService;
import lombok.RequiredArgsConstructor;
import de.ait.taskmanager.models.User;
import org.springframework.stereotype.Service;
import de.ait.taskmanager.repositories.UsersRepository;

import java.util.List;

import static de.ait.taskmanager.dto.UserDto.from;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
   private final UsersRepository usersRepository;


    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public UserDto addUser(NewUserDto userDto) {

        User user = User.builder()
                .loginName(userDto.getLoginName())
                                .build();

        usersRepository.save(user);

        return from(user);
    }
}
