package com.geraldofrancisco.uol_desafio.domain.dto.avenger;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class AvengerCodeNameResponseDTO {

    @JsonProperty("codinome")
    public String codeName;
}
