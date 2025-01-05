package com.geraldofrancisco.uol_desafio.rest.model;

import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import com.geraldofrancisco.uol_desafio.rest.validate.PhoneValidate;
import com.geraldofrancisco.uol_desafio.rest.validate.ValueOfEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_REQUEST_EMAIL_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_REQUEST_NAME_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_REQUEST_PHONE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_REQUEST_TYPE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.EMAIL_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.NAME_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.PHONE_EXAMPLE;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayerCreateRequest {
  @Schema(description = PLAYER_CREATE_REQUEST_NAME_DESCRIPTION, example = NAME_EXAMPLE)
  @NotBlank(message = "PLAYER_CREATE_NAME_REQUIRED")
  private String name;

  @Schema(description = PLAYER_CREATE_REQUEST_EMAIL_DESCRIPTION, example = EMAIL_EXAMPLE)
  @NotBlank(message = "PLAYER_CREATE_EMAIL_REQUIRED")
  @Email(message = "PLAYER_CREATE_EMAIL_INVALID")
  private String email;

  @Schema(description = PLAYER_CREATE_REQUEST_PHONE_DESCRIPTION, example = PHONE_EXAMPLE)
  @PhoneValidate
  private String phone;

  @Schema(description = PLAYER_CREATE_REQUEST_TYPE_DESCRIPTION, implementation = PlayerType.class)
  @NotBlank(message = "PLAYER_CREATE_TYPE_REQUIRED")
  @ValueOfEnum(enumClass = PlayerType.class, message = "PLAYER_CREATE_TYPE_INVALID")
  private String type;
}
