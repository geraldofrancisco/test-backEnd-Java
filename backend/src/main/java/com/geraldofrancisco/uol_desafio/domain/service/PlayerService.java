package com.geraldofrancisco.uol_desafio.domain.service;

import com.geraldofrancisco.uol_desafio.domain.converter.PlayerConverter;
import com.geraldofrancisco.uol_desafio.domain.dto.player.PlayerDTO;
import com.geraldofrancisco.uol_desafio.exception.UOLException;
import com.geraldofrancisco.uol_desafio.repository.PlayerRepository;
import com.geraldofrancisco.uol_desafio.repository.integration.AvengerIntegration;
import com.geraldofrancisco.uol_desafio.repository.integration.JusticeLeagueIntegration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.geraldofrancisco.uol_desafio.domain.enums.ExceptionType.NO_VACANCY_FOR_THE_TYPE;
import static com.geraldofrancisco.uol_desafio.domain.enums.ExceptionType.USER_ALREADY_REGISTERED_FOR_THE_TYPE;

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
    return repository.findByType(dto.getType())
        .collectList()
        .flatMap(previouslySaved ->
            Mono.just(heroes)
                .filter(h -> h.size() > previouslySaved.size())
                .switchIfEmpty(Mono.error(new UOLException(NO_VACANCY_FOR_THE_TYPE)))
                .flatMapMany(Flux::fromIterable)
                .filter(hero -> previouslySaved.stream()
                  .noneMatch(player -> player.getName().equals(dto.getName())))
                .filter(hero -> previouslySaved.stream()
                    .noneMatch(player -> player.getEmail().equals(dto.getEmail())))
                .switchIfEmpty(Mono.error(new UOLException(USER_ALREADY_REGISTERED_FOR_THE_TYPE)))
                .filter(hero -> previouslySaved.stream()
                  .noneMatch(player -> player.getCodename().equals(hero)))
                .next()
        )
        .map(
            hero -> {
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

  public Mono<PageImpl<PlayerDTO>> getPlayers(PageRequest pageable) {
    return repository.count()
      .flatMap(total -> repository.findByOrderByTypeAscNameAsc(pageable)
        .map(PlayerConverter::toDTO)
        .collectList()
        .map(list -> new PageImpl<>(list, pageable, total))
      );
  }
}
