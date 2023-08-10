package de.ait.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import de.ait.taskmanager.models.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Data tasks")
public class TaskDto {

    @Schema(description = "Task ID", example = "1")
    private Long id;


    @Schema(description = "Tasks title", example = "Some task's title...")
    private String title;


    @Schema(description = "Task start date in format:  YYYY-MM-DD", example = "2022-02-02")
    private LocalDate startDate;


    @Schema(description = "Task finish date in format:  YYYY-MM-DD", example = "2022-02-02")
    private String finishDate;

    @Schema(description = "User name, that have a task/")
    private UserInTaskDto about;

    @Schema(description = "Tasks description", example = "Wash car")
    private String description;


    public static TaskDto from(Task task) {
        TaskDto result = TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                           .build();

        if (task.getExecutor() != null) {
            result.setAbout(UserInTaskDto.from(task.getExecutor()));
        }

        if (task.getStartDate() != null) {
            result.setStartDate(task.getStartDate());
        }

        if (task.getFinishDate() != null) {
            result.setFinishDate(task.getFinishDate().toString());
        }

        if (task.getDescription() != null) {
            result.setDescription(task.getDescription());
        }

        return result;
    }

    public static List<TaskDto> from(List<Task> events) {
        return events.stream().map(TaskDto::from).collect(Collectors.toList());
    }


}
