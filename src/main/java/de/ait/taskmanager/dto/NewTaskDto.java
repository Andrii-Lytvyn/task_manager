package de.ait.taskmanager.dto;

import de.ait.taskmanager.validation.constrains.TaskDayAfterToday;
import de.ait.taskmanager.validation.constrains.StartBeforeFinishDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;



import javax.validation.constraints.*;
import java.time.LocalDate;

@Builder
@Data
@StartBeforeFinishDate
@Schema(description = "Data for adding new task")
public class NewTaskDto {

    @Schema(description = "Tasks title", example = "Some task's title...")
    @NotNull
    @NotBlank
    @Size(min=3,max=200)
    private String title;

    @TaskDayAfterToday
    @Schema(description = "Task start date in format:  YYYY-MM-DD", example = "2022-02-02")
    private LocalDate startDate;

    @TaskDayAfterToday
    @Schema(description = "Task finish date in format:  YYYY-MM-DD", example = "2022-02-02")
    private LocalDate finishDate;

    @Schema(description = "Users ID", example = "1")
    private Long aboutUserId;

    @NotNull
    @NotBlank
    @Size(min=3,max=200)
    @Schema(description = "Tasks description", example = "Wash car")
    private String description;
}
