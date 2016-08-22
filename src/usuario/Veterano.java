/**
 * 
 */
package usuario;

import jogo.Jogo;

/**
 * @author melissadg
 *
 */
public class Veterano extends Usuario {
	private double DESCONTO_VETERANO = 0.3;

	public Veterano(String nomeUsuario, String login, double dinheiro) throws Exception {
		super(nomeUsuario, login, dinheiro);
		super.setX2p(1000);

	}


//aki o metodo calcula internamente na classe o proprio desconto e apenas chama o metodo em usuario pra guardar o jogo
	public boolean compraJogos(Jogo jogoRecebido) {
		double precoComDesconto = jogoRecebido.getPreco() - (jogoRecebido.getPreco() * DESCONTO_VETERANO);

		if (precoComDesconto <= super.getDinheiro()) {
			super.setDinheiro(super.getDinheiro() - precoComDesconto);
			return super.compraJogos(jogoRecebido);
		}
		return false;
	}


	/**
	 * Sobreescrita do metodo calculaX2p de usuario aplicando o desconto no
	 * valor do preco
	 */
	@Override
	public int bonusX2p() {
		return 15;
	}

}
