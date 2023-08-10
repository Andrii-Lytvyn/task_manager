package de.ait.taskmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Errors info")
public class ErrorDto {
    @Schema(description = "Error message", example = "Can't find user with specified ID")
    private String message;
}
