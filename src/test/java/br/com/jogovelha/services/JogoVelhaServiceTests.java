package br.com.jogovelha.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class JogoVelhaServiceTests {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public JogoVelhaService jogoVelhaService() {
			return new JogoVelhaService();
		}
	}

	@Autowired
	private JogoVelhaService jogoVelhaService;

	@Test
	public void whenJogoVelha_returnTrue() {
		String[] jogos = { "XXO", "XXX", "XXO" };
		assertTrue(jogoVelhaService.isVelha(jogos));
	}
	
	@Test
	public void whenJogoVelha_returnFalse() {
		String[] jogos = { "XXO", "XOX", "XXO" };
		assertFalse(jogoVelhaService.isVelha(jogos));
	}
	
	@Test
	public void whenJogoVelhaNULL() {
		String[] jogos = null;
		assertFalse(jogoVelhaService.isVelha(jogos));
	}
	
	@Test
	public void whenJogoVelhaEmpty() {
		String[] jogos = {};
		assertFalse(jogoVelhaService.isVelha(jogos));
	}
}
