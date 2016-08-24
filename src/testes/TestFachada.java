/**
 * 
 */
package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Fachada;
import jogo.Jogo;
import jogo.RPG;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

/**
 * @author melissadg
 *
 */
public class TestFachada {
	private Fachada loja = new Fachada();
	private Usuario user1, user2, user3;
	private Jogo jogo1;
	
	/**
	 * Cria os usuarios e o jogo
	 * @throws Exception
	 */
	@Before
	public void criaUsuario() throws Exception {
		user1 = new Noob("Melissa", "mel123", 50.0);
		user2 = new Veterano("Luan", "lulu", 1000.0);
        jogo1 = new RPG("Kingdom Hearts", 15.0);

	}
	
	/**
	 * Testa a adicao de dinheiro 
	 * @throws Exception
	 */
	@Test
	public void testAddDinheiro() throws Exception{
		assertEquals(true, user1.adicionaDinheiro(10.0));
		
		assertEquals(60.0, user1.getDinheiro(), 0.001);
		
		//nao add valor negativo
		try {
			user2.adicionaDinheiro(-10);
			fail("Deve lancar excecao.");
		} catch (Exception e) {
			assertEquals("Valor precisa ser maior que zero.", e.getMessage());
		}
	}

	/**
	 * Faz o teste da adicao de usuarios na lista de usuarios
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdicionaUsuario() throws Exception {

		assertEquals(true, loja.addUsuario(user1));
		assertEquals(true, loja.addUsuario(user2));
		assertEquals(2, loja.getLoja().size());

		try {
			loja.addUsuario(user1);
			fail("Deveria lancar excecao.");
		} catch (Exception e) {
			assertEquals("Usuario ja esta na lista de usuarios.", e.getMessage());

		}
	}
	
	
	/**
	 * testa o upgrade do usuario
	 * @throws Exception
	 */
	@Test
	public void testUpgrade() throws Exception {
		user3 = new Noob("Noobinho", "souNoob", 1.0);
		//atualiza o valor do x2p
		user3.setX2p(1100);
		//add o user na lista
		loja.addUsuario(user3);

		assertEquals(1100, user3.getX2p());
		//faz o upgrade do usuario
		loja.upgrade("souNoob");
		
		//o user recebe o novo usuario
		user3 = loja.retornaUser("souNoob");
		
		assertEquals("Veterano", user3.getClass().getSimpleName());

	}

}
