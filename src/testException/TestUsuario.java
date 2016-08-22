/**
 * 
 */
package testException;

import jogo.Jogo;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public class TestUsuario {

	/**
	 * Metodo que testa a validade do nome do usuario
	 * 
	 * @param nome
	 * @throws Exception
	 */
	public static void testaNomeUsuario(String nome) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome do usuario nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * Metodo que testa a validade do jogo
	 * 
	 * @param nome
	 * @throws Exception
	 */
	public static void testaJogo(Jogo jogo) throws Exception {
		if (jogo == null) {
			throw new Exception("Jogo nao pode ser nulo.");
		}
	}

	/**
	 * Metodos que testa a validade do login do usuario
	 * 
	 * @param login
	 * @throws Exception
	 */
	public static void testaLogin(String login) throws Exception {
		if (login == null || login.trim().equals("")) {
			throw new Exception("Login do usuario nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * Metodos que testa a validade do login do usuario
	 * 
	 * @param login
	 * @throws Exception
	 */
	public static void testaDinheiro(double dinheiro) throws Exception {
		if (dinheiro < 0.0) {
			throw new Exception("Dinheiro precisa ser maior ou igual a zero.");
		}
	}

}
