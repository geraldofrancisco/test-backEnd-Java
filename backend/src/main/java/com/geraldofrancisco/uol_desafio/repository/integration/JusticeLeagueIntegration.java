package com.geraldofrancisco.uol_desafio.repository.integration;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import com.geraldofrancisco.uol_desafio.domain.dto.JusticeLeagueResponseDTO;
import com.geraldofrancisco.uol_desafio.domain.util.XmlUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class JusticeLeagueIntegration {

  @Value("${app.integration.justice-league}")
  private String url;

  private final WebClient webClient;

  public JusticeLeagueIntegration(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<JusticeLeagueResponseDTO> getList() {
    return Mono.just(JusticeLeagueResponseDTO.class)
        .flatMap(            c ->
                webClient
                    .get()
                    .uri(url)
                    .header(CONTENT_TYPE, APPLICATION_XML_VALUE)
                    .retrieve()
                    .bodyToMono(String.class)
                    .map(x -> XmlUtil.toObject(x, c))
                    .cast(c));
  }
}
