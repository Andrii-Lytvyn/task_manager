package de.ait.taskmanager.dto;

import de.ait.taskmanager.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Info about users task")
public class UserInTaskDto {
    @Schema(description = "User ID", example = "1")
    private Long id;

    @Schema(description = "User login name", example = "John")
    private String loginName;

    public static UserInTaskDto from(User user) {
        return UserInTaskDto.builder()
                .id(user.getId())
                .loginName(user.getLoginName())
                .build();
    }
}
