package com.geraldofrancisco.uol_desafio.rest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayerCreateRequest {
    private String name;
    private String email;
    private String phone;
    private String type;
}
