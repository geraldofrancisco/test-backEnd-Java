package com.geraldofrancisco.uol_desafio.domain.service;

import com.geraldofrancisco.uol_desafio.domain.dto.avenger.AvengerCodeNameResponseDTO;
import com.geraldofrancisco.uol_desafio.domain.dto.avenger.AvengerResponseDTO;
import com.geraldofrancisco.uol_desafio.domain.dto.justiceleague.JusticeLeagueCodenameResponseDTO;
import com.geraldofrancisco.uol_desafio.domain.dto.justiceleague.JusticeLeagueResponseDTO;
import com.geraldofrancisco.uol_desafio.repository.integration.AvengerIntegration;
import com.geraldofrancisco.uol_desafio.repository.integration.JusticeLeagueIntegration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class IntegrationService {

  private final Mono<AvengerResponseDTO> cacheAvenger;
  private final Mono<JusticeLeagueResponseDTO> cacheJusticeLeague;

  public IntegrationService(
      JusticeLeagueIntegration justiceLeagueIntegration,
      AvengerIntegration avengerIntegration,
      @Value("${app.cache-duration-minutes.justice-league}") Long justiceLeagueMinutesExpiration,
      @Value("${app.cache-duration-minutes.avenger}") Long avengerMinutesExpiration) {
    this.cacheAvenger =
        Mono.from(avengerIntegration.getList())
            .cache(
                resp -> Duration.ofMinutes(avengerMinutesExpiration),
                t -> Duration.ZERO,
                () -> Duration.ZERO);

    this.cacheJusticeLeague =
        Mono.from(justiceLeagueIntegration.getList())
            .cache(
                resp -> Duration.ofMinutes(justiceLeagueMinutesExpiration),
                t -> Duration.ZERO,
                () -> Duration.ZERO);
  }

  public Flux<String> getAvengers() {
    return cacheAvenger
        .map(AvengerResponseDTO::getAvengers)
        .flatMapMany(Flux::fromIterable)
        .map(AvengerCodeNameResponseDTO::getCodeName);
  }

  public Flux<String> getJusticeLeagues() {
    return cacheJusticeLeague
        .map(JusticeLeagueResponseDTO::getCodeNames)
        .map(JusticeLeagueCodenameResponseDTO::getCodeNames)
        .flatMapMany(Flux::fromIterable);
  }
}
