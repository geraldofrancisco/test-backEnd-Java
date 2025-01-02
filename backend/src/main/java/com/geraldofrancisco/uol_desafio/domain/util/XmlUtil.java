package com.geraldofrancisco.uol_desafio.domain.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class XmlUtil {

  @SneakyThrows
  public static Object toObject(String xml, Class<?> clazz) {
    var mapper = new XmlMapper();
    return mapper.readValue(xml, clazz);
  }
}
