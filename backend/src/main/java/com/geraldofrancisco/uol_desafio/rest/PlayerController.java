package com.geraldofrancisco.uol_desafio.rest;

import com.geraldofrancisco.uol_desafio.domain.service.PlayerService;
import com.geraldofrancisco.uol_desafio.rest.converter.PlayerRequestConverter;
import com.geraldofrancisco.uol_desafio.rest.model.PlayerCreateRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PLAYER_CONTROLLER_DESCRIPTION;

@Validated
@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
@Tag(name = PLAYER_CONTROLLER, description = PLAYER_CONTROLLER_DESCRIPTION)
public class PlayerController {
  private final PlayerService service;

  @PostMapping
  public Mono<Void> create(@Valid @RequestBody PlayerCreateRequest request) {
    return Mono.just(request)
      .map(PlayerRequestConverter::toDTO)
      .flatMap(service::create)
      .then();
  }
}
