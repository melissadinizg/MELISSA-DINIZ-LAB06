/**
 * Certo
 */
package jogo;

import java.util.ArrayList;
import jogo.Jogo;
import usuario.Usuario;
import usuario.Veterano;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public class Fachada {
	private ArrayList<Usuario> loja;
	private Usuario user;
	private Jogo j;

	public Fachada() {
		loja = new ArrayList<>();
	}

	/**
	 * Faz o upgrade do usuario
	 * 
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public boolean upgrade(String login) throws Exception {

		Usuario user = retornaUser(login);

		// se for null eh pq nao existe usuario com o login dado
		if (user != null && user.getX2p() >= 1000) {
			// verifica se eh veterano
			if (user.getClass() != Veterano.class) {

				// pegando os dados do usuario noob
				int x2pNovo = this.user.getX2p();
				String nomeUser = this.user.getNomeUsuario();
				String loginUser = this.user.getLogin();
				double dinheiro = this.user.getDinheiro();

				this.user = new Veterano(nomeUser, loginUser, dinheiro);
				this.user.setX2p(x2pNovo);
				return true;

			}
		} else {
			throw new Exception("Nao foi possivel upar usuario.");
		}
		return false;
	}

	/**
	 * Adiciona o usuario a lista se ele ainda nao for cadastrado
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean addUsuario(Usuario user) {
		//se o usuario
		if (! loja.contains(user)) {
			loja.add(user);
			return true;
		}
		return false;
	}

	/**
	 * Adiciona dinheiro na conta do usuario usando o login passado no parametro
	 * 
	 * @param login
	 * @param valor
	 * @throws Exception
	 */
	public void addDinheiro(String login, int valor) throws Exception {
		// se o user existir na loja
		if (buscaUserLogin(login)) {
			// pega o usuario
			Usuario user = retornaUser(login);
			// delega para o metodo de usuario
			user.adicionaDinheiro(valor);
		}
	}

	/**
	 * Vende o jogo para o usuario se possuir dinheiro suficiente
	 * 
	 * @param jogo
	 * @throws Exception
	 */
	public void vendeJogo(Jogo jogo) throws Exception {
		if (jogo != null) {
			user.compraJogos(jogo);
		} else {
			throw new Exception("O jogo nao pode ser nulo.");
		}

	}


	/**
	 * Retorna o usuario com um login passado
	 * 
	 * @param login
	 * @return Usuarou/null
	 */
	private Usuario retornaUser(String login) {
		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return usuario;
			}
		}
		return null;
	}

	/**
	 * procura o usuario na loja atraves do login
	 * 
	 * @param login
	 * @return boolean
	 * @throws Exception
	 */
	private boolean buscaUserLogin(String login) {

		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna o objeto como string
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder("=== Central P2-CG ===\n");
		double precoTotal = 0.0;

		//percorre a lista de usuario e usando o toString adiciona  na string
		for (Usuario usuario : loja) {

			retorno.append(usuario.toString());
			retorno.append("Lista de Jogos: \n");

			//percorre a lista de jogos e usando o toString adiciona  na string
			for (Jogo jogo : usuario.getListaJogos()) {
				//atualiza o valor de preco total
				precoTotal = precoTotal + jogo.getPreco();
				retorno.append(usuario.toString());

			}
			
			retorno.append("Total de preço dos jogos: R$ " + precoTotal + "\n");
			retorno.append("\n--------------------------------------------");

		}
		//retorna a toString retorno com todos as string adicionada
		return retorno.toString();
	}
}
