package de.ait.taskmanager.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Data Validation Errors")
public class BeforeCurrentDataErrorsDto {

    @Schema(description = "ErrorsList")
    private List<BeforeCurrentDateErrorDto> errors; // список возникших ошибок
}
