package com.geraldofrancisco.uol_desafio.domain.service;

import com.geraldofrancisco.uol_desafio.domain.converter.PlayerConverter;
import com.geraldofrancisco.uol_desafio.domain.dto.player.PlayerDTO;
import com.geraldofrancisco.uol_desafio.repository.PlayerRepository;
import com.geraldofrancisco.uol_desafio.repository.integration.AvengerIntegration;
import com.geraldofrancisco.uol_desafio.repository.integration.JusticeLeagueIntegration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepository repository;
  private final AvengerIntegration avengerIntegration;
  private final JusticeLeagueIntegration justiceLeagueIntegration;

  public Mono<PlayerDTO> create(PlayerDTO dto) {
    switch (dto.getType()) {
      case JUSTICE_LEAGUE -> {
        return justiceLeagueIntegration.get().flatMap(list -> createPlayer(list, dto));
      }
      case AVENGERS -> {
        return avengerIntegration.get().flatMap(list -> createPlayer(list, dto));
      }
    }

    return Mono.empty();
  }

  private Mono<PlayerDTO> createPlayer(List<String> heroes, PlayerDTO dto) {
    return repository
        .findByType(dto.getType())
        .collectList()
        .flatMap(
            previouslySaved ->
                Mono.just(heroes)
                    .filter(h -> h.size() > previouslySaved.size())
                    .switchIfEmpty(
                        Mono.error(
                            new Exception(
                                "Não existe espaço para esse tipo"))) // TODO: CRIAR EXCEÇÃO
                    // PERSONALIZADA
                    .flatMapMany(Flux::fromIterable)
                    .filter(
                        hero ->
                            previouslySaved.stream()
                                .noneMatch(
                                    player -> player.getCodename().equals(dto.getCodename())))
                    .switchIfEmpty(Mono.error(new Exception("usuário já cadastrado")))
                    .filter(
                        hero ->
                            previouslySaved.stream()
                                .noneMatch(player -> player.getCodename().equals(hero)))
                    .next()
        )
        .map(hero -> {
              dto.setCodename(hero);
              return dto;
        })
        .flatMap(this::save);
  }

  private Mono<PlayerDTO> save(PlayerDTO dto) {
    return Mono.just(dto)
        .map(PlayerConverter::toDomain)
        .flatMap(repository::save)
        .map(PlayerConverter::toDTO);
  }
}
