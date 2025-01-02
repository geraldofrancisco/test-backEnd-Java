package com.geraldofrancisco.uol_desafio.repository;

import com.geraldofrancisco.uol_desafio.domain.db.Player;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends R2dbcRepository<Player, Long> {

}
