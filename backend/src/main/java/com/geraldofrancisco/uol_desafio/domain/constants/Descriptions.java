package com.geraldofrancisco.uol_desafio.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Descriptions {
    //Player Controller
    public static final String PLAYER_CONTROLLER = "Controlador de jogadores";
    public static final String PLAYER_CONTROLLER_DESCRIPTION = "Controlador para operações CRUD dos jogadores";

    //Player create request
    public static final String PLAYER_CREATE_REQUEST_NAME = "Nome do jogador";
    public static final String PLAYER_CREATE_REQUEST_EMAIL = "Email do jogador";
    public static final String PLAYER_CREATE_REQUEST_PHONE = "Telefone do jogador";
    public static final String PLAYER_CREATE_REQUEST_TYPE = "Tipo do herói";
}
