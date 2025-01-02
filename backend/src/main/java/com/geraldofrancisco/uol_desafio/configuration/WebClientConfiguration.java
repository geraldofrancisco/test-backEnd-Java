package com.geraldofrancisco.uol_desafio.configuration;

import static io.netty.handler.ssl.util.InsecureTrustManagerFactory.INSTANCE;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfiguration {

  @Bean
  public WebClient restWebClient() {
    return WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(getHttpClient()))
        .build();
  }

  private HttpClient getHttpClient() {
    return HttpClient.create().secure(t -> t.sslContext(getContext()));
  }

  @SneakyThrows
  private SslContext getContext() {
    return SslContextBuilder.forClient().trustManager(INSTANCE).build();
  }
}
