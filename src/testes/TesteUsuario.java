/**
 * 
 */
package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Luta;
import jogo.RPG;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

/**
 * @author Melissa
 *
 */
public class TesteUsuario {
	private Usuario maria, joao, kleber;
	private Jogo jogo1, jogo2;

	/**
	 * Cria os jogos e os usuarios
	 * 
	 * @throws Exception
	 */
	@Before
	public void criaUsuario() throws Exception {
		// usuario: nome, login, dinheiro
		maria = new Noob("Maria", "maria123", 500.0);
		joao = new Veterano("Joao", "j123", 10.0);
		kleber = new Noob("Kleber", "klebinho", 150.0);
		jogo1 = new RPG("Jogo1", 1.0);
		jogo2 = new RPG("Jogo2", 1.0);
	}

	/**
	 * Testa o metodo que adiciona dinheiro na conta
	 * @throws Exception
	 */
	@Test
	public void testAdicionaDinheiro() throws Exception{
		
		assertEquals(500.0, maria.getDinheiro(), 0.001);
		
		maria.adicionaDinheiro(10.0);
		assertEquals(510.0, maria.getDinheiro(), 0.001);
		
		
		// excecao de dinheiro negativo
		try {
			maria.adicionaDinheiro(-1.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Valor precisa ser maior que zero.", e.getMessage());
		
		}
	}
	
	/**
	 * Faz o teste do metodo que compra jogo
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCompraJogo() throws Exception {
		Jogo jogo1 = new RPG("Jogo1", 1.0);
		Jogo jogo2 = new Luta("Jogo2", 35.0);

		// nao compra jogo repetido
		// compra o jogo e testa se realmente comprou
		assertTrue(maria.compraJogos(jogo2));
		assertFalse(maria.compraJogos(jogo2));

		assertTrue(maria.existeJogo(jogo2));
		assertFalse(kleber.existeJogo(jogo1));
	}

	/**
	 * testa o metodo registra jogada e o calculo do x2p quando compra um jogo
	 * 
	 * @throws Exception
	 */
	@Test
	public void registraJogada() throws Exception {

		Usuario laura = new Noob("Laura", "laura123", 500.0);
		Usuario jonas = new Veterano("Jonas", "j123", 10.0);

		laura.registraJogada(jogo1, 800, true);

		assertEquals(1, jogo1.getVezesJogadas());
		assertNotEquals(0, jogo1.getVezesZeradas());

		assertEquals(10, laura.getX2p());

		// jogo RPG/usuario Noob = ganha 10 a cada a cada 1 real
		laura.compraJogos(jogo1);

		// ok
		assertEquals(20, laura.getX2p());
		laura.compraJogos(jogo2);
		assertEquals(30, laura.getX2p());

		// usuario Veterano
		jonas.registraJogada(jogo2, 15, false);
		assertEquals(1010, jonas.getX2p());
		assertEquals(0, jogo2.getVezesZeradas());
		jonas.compraJogos(jogo1);
		// ganhou mais 15 pela compra do jogo
		assertEquals(1025, jonas.getX2p());

	}

	/**
	 * Faz o tratamento de excecoes de usuario
	 */
	@Test
	public void testUsuario() {
		// testa getNome e getLogin
		assertEquals("Joao", joao.getNomeUsuario());
		assertNotEquals("Lucas", joao.getNomeUsuario());
		assertEquals("j123", joao.getLogin());

		// excecao nome nulo
		try {
			maria = new Noob(null, "maria1", 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		// excecao nome vazio
		try {
			maria = new Noob("", "maria1", 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}

		// excecao login nulo
		try {
			maria = new Veterano("Maria", null, 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Login do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}

		// excecao valor dinheiro negativo
		try {
			maria = new Veterano("Maria", "mariacg", -2.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Dinheiro precisa ser maior ou igual a zero.", e.getMessage());
		}
	}
}
