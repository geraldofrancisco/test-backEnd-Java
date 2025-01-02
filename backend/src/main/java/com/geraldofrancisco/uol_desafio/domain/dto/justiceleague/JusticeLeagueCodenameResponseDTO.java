package com.geraldofrancisco.uol_desafio.domain.dto.justiceleague;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JusticeLeagueCodenameResponseDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "codinome")
    List<String> codeNames;
}
