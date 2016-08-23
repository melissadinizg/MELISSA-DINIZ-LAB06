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
    public void criaJogos() throws Exception {
        user1 = new Noob("Melissa", "mel123", 50.0);
        user2 = new Veterano("Luan", "lulu", 1000.0);
    }
	
	@Test
	public void testAdicionaUsuario(){
		assertEquals(true, loja.addUsuario(user1));
		assertEquals(false, loja.addUsuario(user1));
		
		
	}
	@Test
	public void testUpgrade() throws Exception{
		user3 = new Noob("Noobinho", "souNoob", 1.0);
		user3.setX2p(1100);
		loja.addUsuario(user3);
		
		assertEquals(1100, user3.getX2p());
		assertEquals(true, loja.upgrade("souNoob"));
	}
	
	
}
