package com.geraldofrancisco.uol_desafio.repository.integration;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import com.geraldofrancisco.uol_desafio.domain.dto.avenger.AvengerCodeNameResponseDTO;
import com.geraldofrancisco.uol_desafio.domain.dto.avenger.AvengerResponseDTO;
import com.geraldofrancisco.uol_desafio.domain.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class AvengerIntegration {
  @Value("${app.integration.avenger}")
  private String url;

  private final WebClient webClient;

  public Mono<List<String>> get() {
    return Mono.just(AvengerResponseDTO.class)
        .flatMap(
            c ->
                webClient
                    .get()
                    .uri(url)
                    .header(ACCEPT, TEXT_PLAIN_VALUE)
                    .retrieve()
                    .bodyToMono(String.class)
                    .map(json -> JsonUtil.toObject(json, AvengerResponseDTO.class))
                    .cast(c)
                    .map(AvengerResponseDTO::getAvengers)
                    .flatMapMany(Flux::fromIterable)
                    .map(AvengerCodeNameResponseDTO::getCodeName)
                    .collectList()
                    .onErrorResume(
                        e -> {
                          log.error("Something happened in the Avengers integration", e);
                          return Mono.error(e);
                        }))
        .doFirst(() -> log.info("making request to list the avengers"));
  }
}
