package de.ait.taskmanager.controllers.api;

import de.ait.taskmanager.dto.*;
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
import java.util.List;

@Tags(value = {
        @Tag(name = "Users")
})
@RequestMapping("/api/users")
public interface UsersApi {
    @Operation(summary = "Get All Users", description = "Full access")
    @GetMapping
    ResponseEntity<UsersDto> getAllUsers();

    @Operation(summary = "Add user", description = "Admin access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "user added",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })

    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<UserDto> addUser(@Parameter(required = true, description = "User") @RequestBody @Valid NewUserDto newUser);

    @GetMapping("/{user-id}")
    ResponseEntity<UserDto> getUser(@Parameter(required = true, description = "Users ID", example = "3")
                                    @PathVariable("user-id") Long userId);

    @Operation(summary = "Get all users tasks", description = "Full access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Users tasks",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
                    })
    })
    @GetMapping("/{user-id}/tasks")
    ResponseEntity<TasksDto> getTasksOfUser(@Parameter(required = true, description = "Users ID", example = "2")
                                                  @PathVariable("user-id") Long userId);





}
