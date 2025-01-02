package com.geraldofrancisco.uol_desafio.domain.service;

import com.geraldofrancisco.uol_desafio.repository.PlayerRepository;
import com.geraldofrancisco.uol_desafio.repository.integration.AvengerIntegration;
import com.geraldofrancisco.uol_desafio.repository.integration.JusticeLeagueIntegration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;
    private final JusticeLeagueIntegration justiceLeagueIntegration;
    private final AvengerIntegration avengerIntegration;

    public Mono<Void> save() {
        return avengerIntegration.getList()
                .doOnNext(r -> log.info(r.toString()))
                .then();
    }
}
