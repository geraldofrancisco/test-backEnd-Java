package com.geraldofrancisco.uol_desafio.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.ERROR_CODE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.ERROR_FIELDS_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.ERROR_MESSAGE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.ERROR_TIMESTAMP_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.ERROR_CODE_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.TIMESTAMP_EXAMPLE;

@JsonInclude(NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
  @Schema(description = ERROR_TIMESTAMP_DESCRIPTION, example = TIMESTAMP_EXAMPLE)
  @Builder.Default
  private LocalDateTime timestamp = LocalDateTime.now();

  @Schema(description = ERROR_MESSAGE_DESCRIPTION)
  private String errorMessage;

  @Schema(description = ERROR_CODE_DESCRIPTION, example = ERROR_CODE_EXAMPLE)
  private String errorCode;

  @Schema(description = ERROR_FIELDS_DESCRIPTION)
  private List<ErrorFieldResponse> fields;
}
