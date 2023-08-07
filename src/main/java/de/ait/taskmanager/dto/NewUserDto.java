package de.ait.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Users name")
public class NewUserDto {

    @Schema(description = "Users login", example = "John")
    @NotNull
    @NotBlank
    private String loginName;
}
