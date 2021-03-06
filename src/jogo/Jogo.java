/**
 * 
 */
package jogo;

import testException.TestJogo;
import usuario.Usuario;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public abstract class Jogo {
	// atributos do jogo
	private String nome;
	private double preco;
	private int maiorScore, vezesJogadas, vezesZeradas;
	private boolean zerou;
	private Jogabilidade tipo;

	/**
	 * Construtor do jogo
	 * 
	 * @param nome
	 * @param preco
	 * @throws Exception
	 */
	public Jogo(String nome, double preco) throws Exception {
		// testa nome valido
		TestJogo.testaNomeJogo(nome);
		// testa o preco do jogo valido
		TestJogo.testaPrecoJogo(preco);

		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.vezesZeradas = 0;

	}

	/**
	 * Metodo que registra a jogada aumenta o score e atualiza a quantidade de
	 * vezes que zerou
	 * 
	 * @param score
	 * @param zerou
	 */
	public int registraJogada(int score, boolean zerou) throws Exception {
		// testa se o score eh valido
		TestJogo.testaScore(score);

		// verifica se o score recebido eh maior que o atual
		if (maiorScore < score) {
			this.maiorScore = score;

			// atualiza as vezes zeradas
		}
		if (zerou == true) {
			this.vezesZeradas++;
		}

		// atualiza o valor de vezes jogadas
		this.setVezesJogadas(this.getVezesJogadas() + 1);

		// recupera o x2p atual e aplica o bonus do tipo de jogo
		int x2pBonus = bonusX2p();
		return x2pBonus;
	}

	/**
	 * metodo abstrato que sera utilizado para aplicar o bonus
	 * 
	 * @return int bonus
	 */
	abstract int bonusX2p();


	/**
	 * Pega nome
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera nome
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Pega preco
	 * 
	 * @return
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Altera preco
	 * 
	 * @param preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Pega o valor do maior score
	 * 
	 * @return
	 */
	public int getMaiorScore() {
		return maiorScore;
	}

	/**
	 * Altera o maior score
	 * 
	 * @param maiorScore
	 */
	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	/**
	 * Pega a quantidade de vezes jogadas
	 * 
	 * @return
	 */
	public int getVezesJogadas() {
		return vezesJogadas;
	}

	/**
	 * Altera a quantidade de vezes jogadas
	 * 
	 * @param vezesJogadas
	 */
	public void setVezesJogadas(int vezesJogadas) {
		this.vezesJogadas = vezesJogadas;
	}

	/**
	 * Pega a quantidade de vezes jogadas
	 * 
	 * @return
	 */
	public int getVezesZeradas() {
		return vezesZeradas;
	}

	/**
	 * Altera a quantidade de vezes jogadas
	 * 
	 * @param vezesZeradas
	 */
	public void setVezesZeradas(int vezesZeradas) {
		this.vezesZeradas = vezesZeradas;
	}

	/**
	 * O booleano zerou
	 * 
	 * @return
	 */
	public boolean isZerou() {
		return zerou;
	}

	/**
	 * Recupera a jogabilidade
	 * 
	 * @return
	 */
	public Jogabilidade getTipo() {
		return tipo;
	}

	/**
	 * Altera a jogabilidade
	 * 
	 * @param tipo
	 */
	public void setTipo(Jogabilidade tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/*
	 * Dois jogos sao iguais se seus nomes forem iguais
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Jogo)) {
			return false;
		}
		Jogo outro = (Jogo) obj;

		if (outro.getNome() == this.getNome()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * toString da classe jogo
	 */
	@Override
	public String toString() {
		// String que armazena as informacoes
		StringBuilder retorno = new StringBuilder();

		retorno.append("+ " + this.getNome() + " - " + this.getClass().getSimpleName() + ":\n");
		retorno.append("==> Jogou " + this.getVezesJogadas() + " vez(es)\n");
		retorno.append("==> Zerou " + this.getVezesZeradas() + " vez(es)\n");
		retorno.append("==> Mario score: " + this.getMaiorScore() + "\n");

		return retorno.toString();
	}

	
}
