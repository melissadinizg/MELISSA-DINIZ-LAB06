/**
 * 
 */
package usuario;

import jogo.Jogo;

/**
 * @author melissadg
 *
 */
public class Noob extends Usuario {
	private double DESCONTO_NOOB = 0.1;
	private int BONUS = 10;
	
	public Noob(String nomeUsuario, String login, double dinheiro) throws Exception {
		super(nomeUsuario, login, dinheiro);
		super.setX2p(0);
	}

	// aki o metodo calcula internamente na classe o proprio desconto e apenas
	// chama o metodo em usuario pra guardar o jogo
	public boolean compraJogos(Jogo jogoRecebido) {

		double precoComDesconto = jogoRecebido.getPreco() - (jogoRecebido.getPreco() * DESCONTO_NOOB);

		if (precoComDesconto <= super.getDinheiro()) {
			super.setDinheiro(super.getDinheiro() - precoComDesconto);
			return super.compraJogos(jogoRecebido);
		}
		return false;
	}

	/**
	 * Sobreescrita do metodo calculaX2p aplicando o desconto no valor do preco
	 */
	public int bonusX2p() {
		return BONUS;

	}
}