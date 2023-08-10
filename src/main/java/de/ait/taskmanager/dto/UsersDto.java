package de.ait.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "users list")
public class UsersDto {
    @Schema(description = "System users")
    private List<UserDto> users;

    @Schema(description = "Total users count", example = "1")
    private Long count;

    @Schema(description = "Pages Count", example = "3")
    private Integer pagesCount;
}
