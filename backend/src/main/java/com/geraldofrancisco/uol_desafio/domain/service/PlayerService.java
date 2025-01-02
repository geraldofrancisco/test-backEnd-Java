package com.geraldofrancisco.uol_desafio.domain.service;

import com.geraldofrancisco.uol_desafio.domain.db.Player;
import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import com.geraldofrancisco.uol_desafio.repository.PlayerRepository;
import com.geraldofrancisco.uol_desafio.repository.integration.JusticeLeagueIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;
    private final JusticeLeagueIntegration justiceLeagueIntegration;

    public Mono<Void> save() {
        return justiceLeagueIntegration.getList()
                .then();
    }
}
