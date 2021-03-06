package jogo;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public class Plataforma extends Jogo {
	private int BONUS;
	
	/**
	 * Construtor do jogo tipo Plataforma
	 * @param nome
	 * @param preco
	 * @throws Exception
	 */
	public Plataforma(String nome, double preco) throws Exception {
		//nome e preco testados na superclasse

		super(nome, preco);
	}

	/**
	 * Sobreescrita do metodo de jogo
	 * aplica o calculo do bonus
	 */
	@Override
	int bonusX2p() {
		BONUS = super.getVezesZeradas() * 20; 
		return BONUS;
	}

}
