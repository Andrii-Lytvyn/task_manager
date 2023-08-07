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
@Schema(description = "Users tasks")
public class TasksDto {

    @Schema(description = "Tasks list")
    private List<TaskDto> tasks;

    @Schema(description = "Количество tasks пользователя", example = "2")
    private Integer count;
}


