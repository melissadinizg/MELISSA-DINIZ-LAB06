/**
 * 
 */
package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Fachada;
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
	
	@Before
<<<<<<< HEAD
    public void criaUsuario() throws Exception {
=======
    public void criaJogos() throws Exception {
>>>>>>> 783eed9cf6143c9059cf0e0f046afc4a44d35f5e
        user1 = new Noob("Melissa", "mel123", 50.0);
        user2 = new Veterano("Luan", "lulu", 1000.0);
    }
	
<<<<<<< HEAD
	/**
	 * Faz o teste da adicao de usuarios na lista de usuarios
	 * @throws Exception
	 */
	@Test
	public void testAdicionaUsuario() throws Exception{
		
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
	
	@Test
	public void testUpgrade() throws Exception{
		user3 = new Noob("Noobinho", "souNoob", 1.0);
	
=======
	@Test
	public void testAdicionaUsuario(){
		assertEquals(true, loja.addUsuario(user1));
		assertEquals(false, loja.addUsuario(user1));
		
		
	}
	@Test
	public void testUpgrade() throws Exception{
		user3 = new Noob("Noobinho", "souNoob", 1.0);
>>>>>>> 783eed9cf6143c9059cf0e0f046afc4a44d35f5e
		user3.setX2p(1100);
		loja.addUsuario(user3);
		
		assertEquals(1100, user3.getX2p());
<<<<<<< HEAD
		loja.upgrade("souNoob");
		
		//nao ta fazendo o cast
		assertEquals("Veterano", user3.getClass().getSimpleName());
		

	}
	
=======
		assertEquals(true, loja.upgrade("souNoob"));
	}
	
	
>>>>>>> 783eed9cf6143c9059cf0e0f046afc4a44d35f5e
}
