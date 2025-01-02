package com.geraldofrancisco.uol_desafio.domain.dto.justiceleague;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
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
@JacksonXmlRootElement(localName = "liga_da_justica")
public class JusticeLeagueResponseDTO {

  @JacksonXmlProperty(localName = "codinomes")
  private JusticeLeagueCodenameResponseDTO codeNames;
}
