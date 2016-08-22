/**
 * 
 */
package jogo;

/**
 * @author melissadg
 *
 */
public class Luta extends Jogo{

	/**
	 * Construtor do jogo tipo luta
	 * @param nome
	 * @param preco
	 * @throws Exception
	 */
	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	/**
	 * Sobreescrita do metodo de jogo
	 * aplica o calculo do bonus
	 */
	@Override
	int bonusX2p() {
		int bonus = super.getMaiorScore() / 1000;
		return bonus;
	}
	
	
}

