
package jogo;

/**
 * @author melissadg
 *
 */

public class RPG extends Jogo {

	/**
	 * Construtor do jogo tipo RPG
	 * @param nome
	 * @param preco
	 * @throws Exception
	 */
	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	/**
	 * Sobreescrita do metodo de jogo
	 * aplica o calculo do bonus
	 */
	@Override
	int bonusX2p() {
		return super.getVezesJogadas() * 10;
	}

}
