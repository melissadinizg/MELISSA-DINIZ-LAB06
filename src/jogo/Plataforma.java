package jogo;

/**
 * @author melissadg
 *
 */
public class Plataforma extends Jogo {
	
	/**
	 * Construtor do jogo tipo Plataforma
	 * @param nome
	 * @param preco
	 * @throws Exception
	 */
	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	/**
	 * Sobreescrita do metodo de jogo
	 * aplica o calculo do bonus
	 */
	@Override
	int bonusX2p() {
		return super.getVezesZeradas() * 20;
	}

}
