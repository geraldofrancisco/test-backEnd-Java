package com.geraldofrancisco.uol_desafio.exception;

import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.ERROR_FIELD_MESSAGE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.ERROR_FIELD_NAME_DESCRIPTION;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorFieldResponse {
  @Schema(description = ERROR_FIELD_NAME_DESCRIPTION)
  private String name;

  @Schema(description = ERROR_FIELD_MESSAGE_DESCRIPTION)
  private String message;
}
