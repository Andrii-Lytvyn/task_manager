package de.ait.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class NewTaskDto {
    @Schema(description = "Tasks title", example = "Some task's title...")
    private String title;

    @Schema(description = "Task date in format:  YYYY-MM-DD", example = "2022-02-02")
    private String publishDate;

    @Schema(description = "Users ID", example = "1")
    private Long aboutUserId;
}
