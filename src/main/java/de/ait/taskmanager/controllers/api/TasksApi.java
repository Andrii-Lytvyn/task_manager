package de.ait.taskmanager.controllers.api;

import de.ait.taskmanager.dto.TaskDto;
import de.ait.taskmanager.dto.NewTaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tags(value = {
        @Tag(name = "Tasks")
})
@RequestMapping("/api/tasks")
public interface TasksApi {
      @Operation(summary = "Add task to user", description = "Full access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Cant find user with this ID",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "201", description = "Task added",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<TaskDto> addTask(@RequestBody NewTaskDto newArticle);
}
