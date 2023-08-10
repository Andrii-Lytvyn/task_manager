package de.ait.taskmanager.controllers.api;

import de.ait.taskmanager.dto.ErrorDto;
import de.ait.taskmanager.dto.TaskDto;
import de.ait.taskmanager.dto.NewTaskDto;
import de.ait.taskmanager.validation.dto.BeforeCurrentDataErrorsDto;
import de.ait.taskmanager.validation.dto.TaskDayAfterTodayErrorsDro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tags(value = {
        @Tag(name = "Tasks")
})
@RequestMapping("/api/tasks")
public interface TasksApi {
      @Operation(summary = "Add task to user", description = "Full access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Cant find user with this ID",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    }),
            @ApiResponse(responseCode = "201", description = "Task added",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Validation Error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BeforeCurrentDataErrorsDto.class)),
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDayAfterTodayErrorsDro.class))
                    }),

    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<TaskDto> addTask(@Parameter(required = true, description = "Task") @RequestBody @Valid NewTaskDto newTask);
}
