/**
 * 
 */
package jogo;

import testException.TestJogo;
import usuario.Usuario;

/**
 * @author melissadg
 *
 */
public abstract class Jogo {

	private String nome;
	private double preco;
	private int maiorScore, vezesJogadas, vezesZeradas;
	private boolean zerou;
	private Usuario usuario;
	private Jogabilidade tipo;
	
	/**
	 * Construtor do jogo
	 * @param nome
	 * @param preco
	 * @throws Exception 
	 */
	public Jogo(String nome, double preco) throws Exception{
		TestJogo.testaNomeJogo(nome);
		TestJogo.testaPrecoJogo(preco);
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.vezesZeradas = 0;
		
	}
	
	/**
	 * Metodo que registra a jogada
	 * aumenta o score e atualiza 
	 * a quantidade de vezes que zerou
	 * @param score
	 * @param zerou
	 */
	public int registraJogada(int score, boolean zerou){
		if(maiorScore < score){
			maiorScore = score;
			
		}if(zerou == true){
			vezesZeradas ++;
		}
		
		int x2pAtual = usuario.getX2p();
		usuario.setX2p(x2pAtual + bonusX2p());
		return usuario.getX2p();
	}

	/**
	 * metodo abstrato que sera utilizado para aplicar
	 * o bonus 
	 * @return
	 */
	abstract int bonusX2p();

	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		
		retorno.append("+ " + this.getNome() + " - " + this.getClass().getSimpleName() + ":\n");
		retorno.append("==> Jogou " + this.getVezesJogadas() + " vez(es)\n"); 
		retorno.append("==> Zerou " + this.getVezesZeradas() + " vez(es)\n");
		retorno.append("==> Mario score: " + this.getMaiorScore() + "\n");
		
		return retorno.toString();
	}
	
	/**
	 * Pega nome
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Altera nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Pega preco
	 * @return
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Altera preco
	 * @param preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Pega o valor do maior score
	 * @return
	 */
	public int getMaiorScore() {
		return maiorScore;
	}

	/**
	 * Altera o maior score
	 * @param maiorScore
	 */
	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	/**
	 * Pega a quantidade de vezes jogadas
	 * @return
	 */
	public int getVezesJogadas() {
		return vezesJogadas;
	}

	/**
	 * Altera a quantidade de vezes jogadas
	 * @param vezesJogadas
	 */
	public void setVezesJogadas(int vezesJogadas) {
		this.vezesJogadas = vezesJogadas;
	}

	/**
	 * 
	 * @return
	 */
	public int getVezesZeradas() {
		return vezesZeradas;
	}

	/**
	 * 
	 * @param vezesZeradas
	 */
	public void setVezesZeradas(int vezesZeradas) {
		this.vezesZeradas = vezesZeradas;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isZerou() {
		return zerou;
	}

	/**
	 * 
	 * @param zerou
	 */
	public void setZerou(boolean zerou) {
		this.zerou = zerou;
	}

	/**
	 * 
	 * @return
	 */
	public Jogabilidade getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(Jogabilidade tipo) {
		this.tipo = tipo;
	}
}

