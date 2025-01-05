package com.geraldofrancisco.uol_desafio.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Descriptions {
    //Page response
    public static final String PAGE_RESPONSE_PAGE_DESCRIPTION = "Número da página";
    public static final String PAGE_RESPONSE_SIZE_DESCRIPTION = "Tamanho da página";
    public static final String PAGE_RESPONSE_ITEMS_DESCRIPTION = "Lista com os ítens buscados";

    //Player Controller
    public static final String PLAYER_CONTROLLER_NAME_DESCRIPTION = "Controlador de jogadores";
    public static final String PLAYER_CONTROLLER_DESCRIPTION = "Controlador para operações CRUD dos jogadores";

    //Player create controller
    public static final String PLAYER_CONTROLLER_CREATE_SUMMARY_DESCRIPTION = "Criação de jogador";
    public static final String PLAYER_CONTROLLER_CREATE_DESCRIPTION = "Controller que visa criar um novo jogador";


    //Player create request
    public static final String PLAYER_CREATE_REQUEST_NAME_DESCRIPTION = "Nome do jogador";
    public static final String PLAYER_CREATE_REQUEST_EMAIL_DESCRIPTION = "Email do jogador";
    public static final String PLAYER_CREATE_REQUEST_PHONE_DESCRIPTION = "Telefone do jogador. <br /> Formatos válidos: (11) 98765-4321, 11 98765-4321, 1198765-4321, 11 8765-4321, 1187654321";
    public static final String PLAYER_CREATE_REQUEST_TYPE_DESCRIPTION = "Tipo do herói";

    //Player response
    public static final String PLAYER_CREATE_RESPONSE_ID_DESCRIPTION = "Código identificador do jogador";
    public static final String PLAYER_CREATE_RESPONSE_CREATE_DATE_DESCRIPTION = "Data e hora da criação do jogador";
    public static final String PLAYER_CREATE_RESPONSE_CODENAME_DESCRIPTION = "Codename do jogador escolhido aleatóriamente";
    public static final String PLAYER_CREATE_RESPONSE_NAME_DESCRIPTION = "Nome do jogador";
    public static final String PLAYER_CREATE_RESPONSE_EMAIL_DESCRIPTION = "Email do jogador";
    public static final String PLAYER_CREATE_RESPONSE_PHONE_DESCRIPTION = "Telefone do jogador. <br /> Formatos válidos: (11) 98765-4321, 11 98765-4321, 1198765-4321, 11 8765-4321, 1187654321";
    public static final String PLAYER_CREATE_RESPONSE_TYPE_DESCRIPTION = "Tipo do herói";

    //Exception response
    public static final String ERROR_TIMESTAMP_DESCRIPTION = "Data hora da exceção";
    public static final String ERROR_MESSAGE_DESCRIPTION = "Mensagem de erro";
    public static final String ERROR_CODE_DESCRIPTION = "Código do erro";
    public static final String ERROR_FIELDS_DESCRIPTION = "Campos que deram erro de validação em tempo de requisição";
    public static final String ERROR_FIELD_NAME_DESCRIPTION = "Nome do campo";
    public static final String ERROR_FIELD_MESSAGE_DESCRIPTION = "Mensagem de erro do campo";

    //Player get controller
    public static final String PLAYER_CONTROLLER_GET_SUMMARY_DESCRIPTION = "Listagem de jogadores";
    public static final String PLAYER_CONTROLLER_GET_DESCRIPTION = "Controller que visa buscar os jogadores salvos";
    public static final String PLAYER_CONTROLLER_GET_PAGE_DESCRIPTION = "Parâmetro de página que quer buscar";
    public static final String PLAYER_CONTROLLER_GET_SIZE_DESCRIPTION = "Parâmetro de tamanho da página que quer buscar";
}
