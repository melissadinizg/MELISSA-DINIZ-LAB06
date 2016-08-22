/**
 * 
 */
package testes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

/**
 * @author Melissa
 *
 */
public class TesteJogo {
	private Jogo jogo1, jogo2, jogo3;
	
	@Before
	public void criaJogos() throws Exception {
		jogo1 = new RPG("Jogo1", 15.0);
		jogo2 = new Luta("Jogo2", 35.0);
		jogo3 = new Plataforma("Jogo3", 40.0);
		
	}
	
	@Test
	public void testJogos(){
		assertEquals("Jogo1",jogo1.getNome());
		assertEquals("Jogo2", jogo2.getNome());
		assertNotEquals("Jogo5", jogo3.getNome());
	
		//testa nome vazio
		try {
			Jogo jogo6 = new RPG("", 10.0);
			fail("Deveria ter lancado excecao de nome");
			
		} catch (Exception e) {
			assertEquals("Nome do jogo nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//testa nome null
		try {
			Jogo jogo7 = new Luta(null, 99.0);
			fail("Deveria ter lancado excecao de nome");
		} catch (Exception e) {
			assertEquals("Nome do jogo nao pode ser vazio ou nulo.", e.getMessage());
		}
		
		//excecao de preco abaixo de zero
		try {
			Jogo jogo8 = new Luta("Lutinha", -1.0);
			fail("Deveria ter lancado excecao de preco");
		} catch (Exception e) {
			assertEquals("Preco do jogo nao deve ser menor que zero.", e.getMessage());
		}
		
	}
	
	@Test
	public void testCompraJogo(){
	}
}

