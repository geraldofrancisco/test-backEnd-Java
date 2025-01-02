package com.geraldofrancisco.uol_desafio.domain.service;

import com.geraldofrancisco.uol_desafio.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerService {    
    
    private final PlayerRepository repository;
    private final IntegrationService integrationService;

    public Mono<Void> save() {
        return Mono.empty();
    }
}
