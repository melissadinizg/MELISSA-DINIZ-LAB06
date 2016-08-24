//esse mesmo
package jogo;

import java.util.ArrayList;
import jogo.Jogo;
import testException.TestUsuario;
import usuario.Usuario;
import usuario.Veterano;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public class Fachada {
	//atributos de fachada
	private ArrayList<Usuario> loja;
	private Usuario user;

	/**
	 * Construtor de fachada
	 * inicializa o array 
	 */
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
	public void upgrade(String login) throws Exception {
		Usuario user, userNovo;

		// se o usuario existir na lista
		if (buscaUserLogin(login)) {

			user = retornaUser(login);
			// verifica se x2p > 1000 e se ja eh veterano
			if ((user.getX2p() >= 1000) && (user.getClass() != Veterano.class)) {

				// pegando os dados do usuario noob
				int x2pNovo = user.getX2p();
				String nomeUser = user.getNomeUsuario();
				String loginUser = user.getLogin();
				double dinheiro = user.getDinheiro();

				// remove o usuario noob da lista
				loja.remove(user);
				// cria o novo usuario veterano
				userNovo = new Veterano(nomeUser, loginUser, dinheiro);
				// adiciona na lista
				loja.add(userNovo);
				// faz set no x2p do novo usuario
				userNovo.setX2p(x2pNovo);
			}
		} else {
			throw new Exception("Usuario nao esta na lista de usuarios.");
		}

	}

	/**
	 * Busca o usuario na loja atraves do login
	 * 
	 * @param login
	 * @return boolean
	 * @throws Exception
	 */
	private boolean buscaUserLogin(String login) throws Exception{
		TestUsuario.testaLogin(login);
		
		// retorna true se existir o usuario
		// com esse login
		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna o usuario com um login passado
	 * 
	 * @param login
	 * @return Usuarou/null
	 */
	public Usuario retornaUser(String login) {
		Usuario user = null;

		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				// se o usuario estiver na lista retorna o proprio usuario
				user = usuario;
			}
		}
		// ou retorna null se nao existir o usuario
		return user;
	}

	/**
	 * Adiciona o usuario a lista se ele ainda nao for cadastrado
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean addUsuario(Usuario user) throws Exception {

		// se o usuario existir na lista ele retorna true
		if (!loja.contains(user)) {
			loja.add(user);
			return true;
		} else {
			throw new Exception("Usuario ja esta na lista de usuarios.");
		}
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
		// faz a venda do jogo
		if (jogo != null) {
			user.compraJogos(jogo);
		} else {
			throw new Exception("O jogo nao pode ser nulo.");
		}
	}

	/**
	 * Sobreescrita do metodo toString retorna o objeto como string
	 */
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder("=== Central P2-CG ===\n");
		double precoTotal = 0.0;

		// percorre a lista de usuario e usando o toString adiciona na string
		for (Usuario usuario : loja) {

			retorno.append(usuario.toString());
			retorno.append("Lista de Jogos: \n");

			// percorre a lista de jogos e usando o toString adiciona na string
			for (Jogo jogo : usuario.getListaJogos()) {
				// atualiza o valor de preco total
				precoTotal = precoTotal + jogo.getPreco();
				retorno.append(usuario.toString());

			}
			// armazena na string o total de preco dos jogos
			retorno.append("\nTotal de preço dos jogos: R$ " + precoTotal + "\n");
			retorno.append("\n--------------------------------------------");

		}
		// retorna a toString retorno com todos as string adicionada
		return retorno.toString();
	}

	/**
	 * @return the loja
	 */
	public ArrayList<Usuario> getLoja() {
		return loja;
	}

	/**
	 * @return the user
	 */
	public Usuario getUser() {
		return user;
	}
}
