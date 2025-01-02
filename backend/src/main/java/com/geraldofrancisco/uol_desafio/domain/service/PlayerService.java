package com.geraldofrancisco.uol_desafio.domain.service;

import com.geraldofrancisco.uol_desafio.domain.db.Player;
import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import com.geraldofrancisco.uol_desafio.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;


    public Mono<Void> save() {
        return repository.save(Player.builder()
                        .type(PlayerType.AVENGERS)
                        .codename("xpto")
                        .name("name")
                        .email("email")
                        .build()
                )
                .then();
    }
}
