package com.geraldofrancisco.uol_desafio.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_RESPONSE_CODENAME_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_RESPONSE_CREATE_DATE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_RESPONSE_EMAIL_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_RESPONSE_ID_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_RESPONSE_NAME_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_RESPONSE_PHONE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CREATE_RESPONSE_TYPE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.CODENAME_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.EMAIL_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.ID_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.NAME_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.PHONE_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.TIMESTAMP_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.Example.TYPE_RESPONSE_EXAMPLE;
import static com.geraldofrancisco.uol_desafio.domain.constants.UOLConstants.DATE_ISO_FORMAT;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayerResponse {
    @Schema(description = PLAYER_CREATE_RESPONSE_ID_DESCRIPTION, example = ID_EXAMPLE)
    private Long id;

    @Schema(description = PLAYER_CREATE_RESPONSE_CREATE_DATE_DESCRIPTION, example = TIMESTAMP_EXAMPLE)
    @JsonFormat(pattern = DATE_ISO_FORMAT)
    private LocalDateTime creationDate;

    @Schema(description = PLAYER_CREATE_RESPONSE_NAME_DESCRIPTION, example = NAME_EXAMPLE)
    private String name;

    @Schema(description = PLAYER_CREATE_RESPONSE_EMAIL_DESCRIPTION, example = EMAIL_EXAMPLE)
    private String email;

    @Schema(description = PLAYER_CREATE_RESPONSE_PHONE_DESCRIPTION, example = PHONE_EXAMPLE)
    private String phone;

    @Schema(description = PLAYER_CREATE_RESPONSE_CODENAME_DESCRIPTION, example = CODENAME_EXAMPLE)
    private String codename;

    @Schema(description = PLAYER_CREATE_RESPONSE_TYPE_DESCRIPTION, example = TYPE_RESPONSE_EXAMPLE)
    private String type;
}
