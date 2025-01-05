package com.geraldofrancisco.uol_desafio.rest;

import com.geraldofrancisco.uol_desafio.domain.service.PlayerService;
import com.geraldofrancisco.uol_desafio.exception.ExceptionResponse;
import com.geraldofrancisco.uol_desafio.rest.converter.PlayerRequestConverter;
import com.geraldofrancisco.uol_desafio.rest.model.PlayerCreateRequest;
import com.geraldofrancisco.uol_desafio.rest.model.PlayerResponsePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_CREATE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_CREATE_SUMMARY_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_GET_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_GET_PAGE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_GET_SIZE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_GET_SUMMARY_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_NAME_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_DESCRIPTION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
@Tag(name = PLAYER_CONTROLLER_NAME_DESCRIPTION, description = PLAYER_CONTROLLER_DESCRIPTION)
@ApiResponse(
    responseCode = "500",
    content =
        @Content(
            mediaType = APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ExceptionResponse.class)))
@ApiResponse(
    responseCode = "400",
    content =
        @Content(
            mediaType = APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ExceptionResponse.class)))
@ApiResponse(
    responseCode = "404",
    content =
        @Content(
            mediaType = APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ExceptionResponse.class)))
@ApiResponse(
    responseCode = "422",
    content =
        @Content(
            mediaType = APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ExceptionResponse.class)))
public class PlayerController {
  private final PlayerService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = PLAYER_CONTROLLER_CREATE_SUMMARY_DESCRIPTION,
      description = PLAYER_CONTROLLER_CREATE_DESCRIPTION)
  public Mono<Void> create(@Valid @RequestBody PlayerCreateRequest request) {
    return Mono.just(request).map(PlayerRequestConverter::toDTO).flatMap(service::create).then();
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = PLAYER_CONTROLLER_GET_SUMMARY_DESCRIPTION,
      description = PLAYER_CONTROLLER_GET_DESCRIPTION
  )
  public Mono<PlayerResponsePage> getPage(
          @Parameter(description = PLAYER_CONTROLLER_GET_PAGE_DESCRIPTION)
          @RequestParam(required = false, defaultValue = "0")
          final Integer page,
          @Parameter(description = PLAYER_CONTROLLER_GET_SIZE_DESCRIPTION)
          @RequestParam(required = false, defaultValue = "5")
          final Integer size
          ) {
    return Mono.empty();
  }
}
