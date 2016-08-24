package testes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public class TesteJogo {
	// declaracao das variaveis
	private Jogo jogo1, jogo2, jogo3, jogo4;

	/**
	 * Cria os jogos de diversos tipos
	 * 
	 * @throws Exception
	 */
	@Before
	public void criaJogos() throws Exception {
		jogo1 = new RPG("Kingdom Hearts", 15.0);
		jogo2 = new Luta("Street Fighter", 35.0);
		jogo3 = new Plataforma("Sonic", 40.0);
		jogo4 = new RPG("Legend of zelda", 75.0);

	}
	
	/**
	 * Faz o teste do registra jogada de jogo
	 * @throws Exception
	 */
	@Test
	public void testRegistraJogada() throws Exception {
		// registra jogada no jogo1
		jogo1.registraJogada(10000, false);

		//verifica os gets
		assertEquals(0, jogo1.getVezesZeradas());
		assertNotEquals(2, jogo1.getVezesZeradas());
		assertEquals(1, jogo1.getVezesJogadas());

		assertEquals(0, jogo3.getVezesJogadas());

		//registra jogada 
		jogo2.registraJogada(750, false);
		jogo3.registraJogada(850, false);
		jogo3.registraJogada(950, false);
		
		assertNotEquals(true, jogo1.isZerou());
		assertEquals(750, jogo2.getMaiorScore());
		assertEquals(false, jogo1.isZerou());
		assertNotEquals(940, jogo2.getMaiorScore());

		
		// testa no score negativo
		try {
			jogo4.registraJogada(-15, true);
			fail("Deveria ter lancado excecao de score");
		} catch (Exception e) {
			assertEquals("Score nao pode ser menor que 0.", e.getMessage());
		}

	}

	/**
	 * faz o tratamento das excecoes
	 */
	@Test
	public void testJogos() {
		assertEquals("Kingdom Hearts", jogo1.getNome());
		assertEquals("Street Fighter", jogo2.getNome());
		assertEquals("Sonic", jogo3.getNome());
		assertEquals("Plataforma", jogo3.getClass().getSimpleName());
		assertEquals("Luta", jogo2.getClass().getSimpleName());
		assertEquals("RPG", jogo4.getClass().getSimpleName());

		// testa nome vazio
		try {
			Jogo jogo6 = new RPG("", 10.0);
			fail("Deveria ter lancado excecao de nome");

		} catch (Exception e) {
			assertEquals("Nome do jogo nao pode ser vazio ou nulo.", e.getMessage());
		}

		// testa nome null
		try {
			Jogo jogo7 = new Luta(null, 99.0);
			fail("Deveria ter lancado excecao de nome");
		} catch (Exception e) {
			assertEquals("Nome do jogo nao pode ser vazio ou nulo.", e.getMessage());
		}

		// excecao de preco abaixo de zero
		try {
			Jogo jogo8 = new Luta("Lutinha", -1.0);
			fail("Deveria ter lancado excecao de preco");
		} catch (Exception e) {
			assertEquals("Preco do jogo nao deve ser menor que zero.", e.getMessage());
		}

	}

}