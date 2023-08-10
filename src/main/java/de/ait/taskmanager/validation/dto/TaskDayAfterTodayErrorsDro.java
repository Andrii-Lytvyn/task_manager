package de.ait.taskmanager.validation.dto;

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
@Schema(description = "TaskDayAfterToday Errors")
public class TaskDayAfterTodayErrorsDro {
    @Schema(description = "ErrorsList")
    private List<TaskDayAfterTodayErrorDro> errors;
}
