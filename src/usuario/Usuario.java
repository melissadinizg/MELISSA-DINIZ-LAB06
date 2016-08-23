/**
 * 
 */
package usuario;

import java.util.ArrayList;

import jogo.Jogo;
import testException.TestUsuario;

/**
 * @author melissadg
 *
 */

import java.util.ArrayList;
import jogo.Jogo;
import testException.TestUsuario;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public abstract class Usuario {
	private String nomeUsuario, login;
	private double dinheiro;
	private ArrayList<Jogo> listaJogos;
	private int x2p;

	/**
	 * Construtor do Usuario
	 * 
	 * @param nomeUsuario
	 * @param login
	 * @param dinheiro
	 * @throws Exception
	 */
	public Usuario(String nomeUsuario, String login, double dinheiro) throws Exception {
		//faz o teste de excecoes
		TestUsuario.testaNomeUsuario(nomeUsuario);
		TestUsuario.testaLogin(login);
		TestUsuario.testaDinheiro(dinheiro);
		
		this.nomeUsuario = nomeUsuario;
		this.login = login;
		this.dinheiro = dinheiro;
		this.listaJogos = new ArrayList<>();
	}


	
	
	/**
	 * Metodo que realiza a compra dos jogos
	 * 
	 * @param jogoRecebido
	 * @return
	 */
	public boolean compraJogos(Jogo jogoRecebido) {
		//pega o preco do jogo e faz cast pra int
		int preco = (int)jogoRecebido.getPreco();
		
		if (!existeJogo(jogoRecebido)) {
			//atualiza o x2p aplicando o bonus da compra
			this.setX2p(calculaX2p(jogoRecebido));
			return listaJogos.add(jogoRecebido);
		}
		//ou exception de jogo ja comprado
		return false;
	}
	
	/**
	 * Metodo que atualiza o valor do x2p do usuario
	 * @param jogoRecebido
	 * @return x2p
	 */
	public int calculaX2p(Jogo jogoRecebido){
		int somaValor = this.getX2p() + (int)jogoRecebido.getPreco() * bonusX2p();
		this.setX2p(somaValor);
		return this.getX2p();
	}
	
	/**
	 * verifica se o jogo ja existe na lista de jogos
	 * @param jogoRecebido
	 * @return true se o jogo estiver na lista de jogos
	 * @throws Exception 
	 */
	public boolean existeJogo(Jogo jogoRecebido) {
		for (Jogo jogo : listaJogos) {
			if (jogo.equals(jogoRecebido)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param nomeDoJogo
	 * @param score
	 * @param zerou
	 * @throws Exception 
	 */
	public int registraJogada(Jogo nomeDoJogo, int score, boolean zerou) throws Exception{
		//pega o bonus calculado em jogo
		int bonus = nomeDoJogo.registraJogada(score, zerou);
		//atualiza o valor do x2p do usuario
		this.setX2p(this.getX2p() + bonus);
		return this.getX2p();
	}
	
	/**
	 * Metodo abstrato que eh usado para pegar o valor do bonus do usuario
	 * @return
	 */
	abstract int bonusX2p();
	
	/**
	 * 
	 * @param valor
	 * @return
	 * @throws Exception
	 */
	public boolean adicionaDinheiro(double valor) throws Exception{
		
		if (valor < 0) {
			throw new Exception("Valor precisa ser maior que zero.");
		}else{
			
			this.setDinheiro(this.getDinheiro() + valor);
			return true;
		}
	}
	
	@Override
	public String toString() {
		return this.getLogin() +"\n" + this.getNomeUsuario() + " - " + "Jogador" + this.getClass().getSimpleName() + "\n"; 
	}

	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}


	/**
	 * @param nomeUsuario the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return the dinheiro
	 */
	public double getDinheiro() {
		return dinheiro;
	}


	/**
	 * @param dinheiro the dinheiro to set
	 */
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}


	/**
	 * @return the listaJogos
	 */
	public ArrayList<Jogo> getListaJogos() {
		return listaJogos;
	}

	/**
	 * @param listaJogos the listaJogos to set
	 */
	public void setListaJogos(ArrayList<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
	}

	/**
	 * @return the x2p
	 */
	public int getX2p() {
		return x2p;
	}

	/**
	 * @param x2p the x2p to set
	 */
	public void setX2p(int x2pNovo) {
		this.mudaX2p(x2pNovo);
	}
	
	/**
	 * Para alterar o valor do x2p no Usuario
	 * @param x2pNovo
	 */
	private void mudaX2p(int x2pNovo){
		this.x2p = x2pNovo;
	}
	
}
