package com.geraldofrancisco.uol_desafio.rest.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PAGE_RESPONSE_HAS_NEXT_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PAGE_RESPONSE_IS_LAST_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PAGE_RESPONSE_ITEMS_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PAGE_RESPONSE_PAGE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PAGE_RESPONSE_SIZE_DESCRIPTION;
import static com.geraldofrancisco.uol_desafio.domain.constants.Descriptions.PAGE_RESPONSE_TOTAL_PAGES_DESCRIPTION;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class PageResponse<T> {
  @Schema(description = PAGE_RESPONSE_PAGE_DESCRIPTION)
  private Integer page;

  @Schema(description = PAGE_RESPONSE_SIZE_DESCRIPTION)
  private Integer size;

  @Schema(description = PAGE_RESPONSE_TOTAL_PAGES_DESCRIPTION)
  private Integer totalPages;

  @Schema(description = PAGE_RESPONSE_IS_LAST_DESCRIPTION)
  private boolean isLast;

  @Schema(description = PAGE_RESPONSE_HAS_NEXT_DESCRIPTION)
  private boolean hasNext;

  @Schema(description = PAGE_RESPONSE_ITEMS_DESCRIPTION)
  private List<T> items;
}
