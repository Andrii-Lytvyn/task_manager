package de.ait.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import de.ait.taskmanager.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @Schema(description = "User ID", example = "1")
    private Long id;


    @Schema(description = "Users Email", example = "simple@mail.com" )
    private String email;

    @Schema(description = "Users Role - ADMIN, USER, MANAGER", example = "ADMIN")
    private String role;

    @Schema(description = "Users status - NOT_CONFIRMED, " +
            "CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
    private String state;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .state(user.getState().name())
                .role(user.getRole().name())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
    }
