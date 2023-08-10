package de.ait.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Schema(description = "Date for update")
@Builder
public class UpdateUserDto {

    @Schema(description = "Users role: USER, MANAGER", example = "USER")
    private String newRole;

    @Schema(description = "Users status- NOT_CONFIRMED, " +
            "CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
    private String newState;
}
