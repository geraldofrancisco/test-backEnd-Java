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

import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_REQUEST_EMAIL;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_REQUEST_NAME;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_REQUEST_PHONE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_REQUEST_TYPE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.EMAIL_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.NAME_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.PHONE_EXAMPLE;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayerCreateRequest {
  @Schema(description = PLAYER_CREATE_REQUEST_NAME, example = NAME_EXAMPLE)
  @NotBlank
  private String name;

  @Schema(description = PLAYER_CREATE_REQUEST_EMAIL, example = EMAIL_EXAMPLE)
  @NotBlank
  @Email
  private String email;

  @Schema(description = PLAYER_CREATE_REQUEST_PHONE, example = PHONE_EXAMPLE)
  @PhoneValidate
  private String phone;

  @Schema(description = PLAYER_CREATE_REQUEST_TYPE, implementation = PlayerType.class)
  @NotBlank
  @ValueOfEnum(enumClass = PlayerType.class)
  private String type;
}
