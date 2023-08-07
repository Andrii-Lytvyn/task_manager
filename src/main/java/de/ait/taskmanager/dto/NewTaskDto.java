package de.ait.taskmanager.dto;

import de.ait.taskmanager.validation.constrains.BeforeCurrentDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;



import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Schema(description = "Data for adding new task")
public class NewTaskDto {

    @Schema(description = "Tasks title", example = "Some task's title...")
    @NotNull
    @NotBlank
    @Size(min=3,max=200)
    private String title;

    @BeforeCurrentDate
    @Schema(description = "Task start date in format:  YYYY-MM-DD", example = "2022-02-02")
    private LocalDate startDate;

    @BeforeCurrentDate
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
