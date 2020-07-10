package br.com.jogovelha.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class JogoVelhaService {

	private static final String[] JOGADAS_PARA_VENCER = { "XXX", "OOO" };

	public boolean isVelha(String[] jogos) {

		if (jogos == null)
			return false;

		return Arrays.stream(jogos).filter(jogo -> {
			return Arrays.stream(JOGADAS_PARA_VENCER).anyMatch(jogo::equals);
		}).findFirst().isPresent();
	}
}
