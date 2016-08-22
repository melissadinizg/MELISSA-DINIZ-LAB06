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

	@Before
	public void criaUsuario() throws Exception {
		maria = new Noob("Maria", "maria123", 500.0);
		joao = new Veterano("Joao", "j123", 10.0);
		kleber = new Noob("Kleber", "klebinho", 150);
		jogo1 = new RPG("Jogo1", 1.0); 
		jogo2 = new RPG("Jogo2", 1.0);
	}
	
	@Test
	public void testX2p() throws Exception{
	
		maria.compraJogos(jogo1); //10
		joao.compraJogos(jogo1); //15
		
		assertEquals(10, maria.calculaX2p(jogo1));
		assertEquals(1015, joao.calculaX2p(jogo1));
		
		maria.compraJogos(jogo2);
		joao.compraJogos(jogo2);
		kleber.compraJogos(jogo1);
		
		assertEquals(10, kleber.calculaX2p(jogo1));
		assertEquals(20, maria.calculaX2p(jogo2));
		assertEquals(1030, joao.calculaX2p(jogo2));

	}
	
	@Test
	public void testCompraJogo() throws Exception{
		Jogo jogo1 = new RPG("Jogo1", 1.0);
		Jogo jogo2 = new Luta("Jogo2", 35.0);
		
		assertTrue(maria.compraJogos(jogo2));
		assertFalse(maria.compraJogos(jogo2));
		
		assertTrue(maria.existeJogo(jogo2));
		assertFalse(kleber.existeJogo(jogo1));
	}
	
	@Test
	public void testUsuario(){
		//testa getNome e getLogin
		assertEquals("Joao", joao.getNomeUsuario());
		assertNotEquals("Lucas", joao.getNomeUsuario());
		assertEquals("j123", joao.getLogin());
		
		//excecao nome vazio
		try {
			maria = new Noob("", "maria1", 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//excecao login nulo
		try {
			maria = new Veterano("Maria", null, 5.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Login do usuario nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//excecao valor dinheiro negativo
		try {
			maria = new Veterano("Maria", "mariacg", -2.0);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Dinheiro precisa ser maior ou igual a zero.", e.getMessage());
		}
	}
