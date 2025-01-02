package com.geraldofrancisco.uol_desafio.domain.service;

import com.geraldofrancisco.uol_desafio.domain.dto.player.PlayerDTO;
import com.geraldofrancisco.uol_desafio.repository.PlayerRepository;
import com.geraldofrancisco.uol_desafio.repository.integration.AvengerIntegration;
import com.geraldofrancisco.uol_desafio.repository.integration.JusticeLeagueIntegration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
                return justiceLeagueIntegration.get()
                        .flatMap(list -> createPlayer(list, dto));
            }
            case AVENGERS -> {
                return avengerIntegration.get()
                        .flatMap(list -> createPlayer(list, dto));
            }
        }

        return Mono.empty();
    }

    private Mono<PlayerDTO> createPlayer (List<String> heroes, PlayerDTO dto) {
        return Mono.just(dto);
    }
}
