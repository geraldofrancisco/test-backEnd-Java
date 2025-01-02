package com.geraldofrancisco.uol_desafio.repository;

import com.geraldofrancisco.uol_desafio.domain.db.Player;
import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PlayerRepository extends R2dbcRepository<Player, Long> {
    Flux<Player> findByType(PlayerType type);
}
