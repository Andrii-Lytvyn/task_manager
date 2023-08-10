package de.ait.taskmanager.dto;

import de.ait.taskmanager.validation.constrains.NotWeakPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@Schema(description = "Users name")
public class NewUserDto {

    @Schema(description = "Users login", example = "John")
    @Email
    @NotNull
    @NotBlank
    private String email;


    @Schema(description = "Пароль пользователя", example = "qwerty007")
    @NotBlank
    @Size(min = 7, max = 1000)
    @NotWeakPassword
    private String password;

}
