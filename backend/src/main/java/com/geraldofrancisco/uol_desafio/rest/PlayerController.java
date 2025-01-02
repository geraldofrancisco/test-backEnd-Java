package com.geraldofrancisco.uol_desafio.rest;

import com.geraldofrancisco.uol_desafio.domain.service.PlayerService;
import com.geraldofrancisco.uol_desafio.rest.converter.PlayerRequestConverter;
import com.geraldofrancisco.uol_desafio.rest.model.PlayerCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
public class PlayerController {
  private final PlayerService service;

  @PostMapping
  public Mono<Void> create(@RequestBody PlayerCreateRequest request) {
    return Mono.just(request)
      .map(PlayerRequestConverter::toDTO)
      .flatMap(service::create)
      .then();
  }
}
