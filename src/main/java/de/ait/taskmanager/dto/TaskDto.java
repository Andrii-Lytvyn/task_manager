package de.ait.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import de.ait.taskmanager.models.Task;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {

    private Long id;
    private String title;
    private String description;

    public static TaskDto from (Task task){
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }

    public static List<TaskDto> from (List<Task> events){
        return events.stream().map(TaskDto::from).collect(Collectors.toList());
    }



}
