package com.geraldofrancisco.uol_desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value={H2ConsoleAutoConfiguration.class})
public class UolDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UolDesafioApplication.class, args);
	}

}
