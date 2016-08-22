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
	private Jogo jogo1, jogo2, jogo3, jogo9;
	/*
	@Before
	public void criaJogos1() throws Exception {
		jogo1 = new RPG("Jogo1", 15.0);
		jogo2 = new Luta("Jogo2", 35.0);
		jogo3 = new Plataforma("Jogo3", 40.0);
		
	}
	
	@Test
	public void testJogos1(){
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
	*/
    
    
    /**
     * Criando jogos do tipo RPG, Luta e Plataforma
     * @throws Exception
     */
    
    
    @Before
    public void criaJogos() throws Exception {
        jogo1 = new RPG("World of Warcraft", 15.0);
        jogo2 = new Luta("Mortal Kombat", 35.0);
        jogo3 = new Plataforma("Mario Bros", 40.0);
        jogo9 = new RPG("Paper Mario", 75);
        
    }
    
    
    /**
     * Testes e asserts dos metodos de Jogo 
     */
    
    
    @Test
    public void testJogos() {
        assertEquals("World of Warcraft",jogo1.getNome());
        assertEquals("Mortal Kombat", jogo2.getNome());
        assertNotEquals("Sonic Origins", jogo3.getNome());
        assertEquals("Plataforma", jogo3.getClass().getSimpleName());
        assertNotEquals("Luta", jogo1.getClass().getSimpleName());
        assertEquals("RPG", jogo9.getClass().getSimpleName());
        
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
            fail("Deveria ter langetMaiorScorecado excecao de nome");
        } catch (Exception e) {
            assertEquals("Nome do jogo nao pode ser vazio ou nulo.", e.getMessage());
        }
        
        //excecao de preco abaixo de zero
        
        
        try {
            Jogo jogo8 = new Luta("Street Fighter", -1.0);
            fail("Deveria ter lancado excecao de preco");
        } catch (Exception e) {
            assertEquals("Preco nao pode ser menor que 0.", e.getMessage());
        }
        
    }
    
    
    /**
     * Registrando jogadas
     * @throws Exception
     */
    
    
    @Before
    public void criaRegistraJogada() throws Exception {
        jogo1.registraJogada(50000, true);
        jogo2.registraJogada(80000, false);
        jogo3.registraJogada(5000, true);
    }
    
    
    /**
     * Testes para o metodo registraJogada
     */
    
    
    @Test
    public void testRegistraJogada() {
        assertEquals(1, jogo1.getVezesZeradas());
        assertNotEquals(2, jogo1.getVezesZeradas());
        assertEquals(80000, jogo2.getMaiorScore());
        assertEquals(1, jogo3.getVezesJogadas());
        
        
        try {
            jogo9.registraJogada(-15, true);
            fail("Deveria ter lancado excecao de score");
        } catch (Exception e) {
            assertEquals("Score não pode ser menor ou igual a 0", e.getMessage());
        }
        
        
        
    }
    
}


