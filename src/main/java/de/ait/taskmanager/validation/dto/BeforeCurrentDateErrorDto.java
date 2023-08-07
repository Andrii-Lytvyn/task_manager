package de.ait.taskmanager.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Date validation error")
public class BeforeCurrentDateErrorDto {

    @Schema(description = "Field with error", example = "startDate")
    private String field;

    @Schema(description = "Error message", example = "Start date cant be earlier today ")
    private String message;

    @Schema(description = "date,that write user", example = "01.01.2000")
    private String rejectedValue;
}
