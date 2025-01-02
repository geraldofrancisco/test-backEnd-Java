package com.geraldofrancisco.uol_desafio.domain.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

  @SneakyThrows
  public static Object toObject(String json, Class<?> clazz) {
    var mapper = new ObjectMapper();
    return mapper.readValue(json, clazz);
  }
}
