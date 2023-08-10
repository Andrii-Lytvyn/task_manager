package de.ait.taskmanager.validation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 7/28/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Validation error")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ValidationErrorDto {

    @Schema(description = "Errors field", example = "email")
    private String field;

    @Schema(description = "Errors message", example = "must be a well-formed email address")
    private String message;

    @Schema(description = "Rejected Value from user", example = "sidikov.marsel.com")
    private String rejectedValue;
}
