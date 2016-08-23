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
	
<<<<<<< HEAD
	public void upgrade(String login) throws Exception {
		Usuario user;
		if (buscaUserLogin(login)) {
			
			user = retornaUser(login);
			
 			if ((user.getX2p() >= 1000) && (user.getClass() != Veterano.class)){
 				
 			// pegando os dados do usuario noob
				int x2pNovo = user.getX2p();
				String nomeUser = user.getNomeUsuario();
				String loginUser = user.getLogin();
				double dinheiro = user.getDinheiro();
=======
	public boolean upgrade(String login) throws Exception {

		Usuario user = retornaUser(login);

		//se for true o user ja existe na lista com o login dado
		if (buscaUserLogin(login) && user.getX2p() >= 1000) {
			// verifica se eh veterano
			if (user.getClass() != Veterano.class) {

				// pegando os dados do usuario noob
				int x2pNovo = this.user.getX2p();
				String nomeUser = this.user.getNomeUsuario();
				String loginUser = this.user.getLogin();
				double dinheiro = this.user.getDinheiro();
>>>>>>> 783eed9cf6143c9059cf0e0f046afc4a44d35f5e

				this.user = new Veterano(nomeUser, loginUser, dinheiro);
				this.user.setX2p(x2pNovo);
			}
		}else{
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
	private boolean buscaUserLogin(String login) {
		//retorna true se existir o usuario
		//com esse login
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
	private Usuario retornaUser(String login) {
		Usuario user = null;
		
		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				//se o usuario estiver na lista retorna o proprio usuario
				user = usuario;
			}
		}
		//ou retorna null se nao existir o usuario
		return user;
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
				//se o usuario estiver na lista retorna o proprio usuario
				return usuario;
			}
		}
		//ou retorna null se nao existir o usuario
		return null;
	}

	/**
	 * Adiciona o usuario a lista se ele ainda nao for cadastrado
	 * @param user
	 * @return boolean
	 */
<<<<<<< HEAD
	public boolean addUsuario(Usuario user) throws Exception{
=======
	public boolean addUsuario(Usuario user) {
>>>>>>> 783eed9cf6143c9059cf0e0f046afc4a44d35f5e
		//se o usuario existir na lista ele retorna true
		if (! loja.contains(user)) {
			loja.add(user);
			return true;
		}else{
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
		//faz a venda do jogo
		if (jogo != null) {
			user.compraJogos(jogo);
		} else {
			throw new Exception("O jogo nao pode ser nulo.");
		}
	}


<<<<<<< HEAD

=======


	/**
	 * Busca o usuario na loja atraves do login
	 * 
	 * @param login
	 * @return boolean
	 * @throws Exception
	 */
	private boolean buscaUserLogin(String login) {
		//retorna true se existir o usuario
		//com esse login
		for (Usuario usuario : loja) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return true;
			}
		}
		return false;
	}
>>>>>>> 783eed9cf6143c9059cf0e0f046afc4a44d35f5e

	/**
	 * Sobreescrita do metodo toString 
	 * retorna o objeto como string
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
			//armazena na string o total de preco dos jogos
			retorno.append("\nTotal de preço dos jogos: R$ " + precoTotal + "\n");
			retorno.append("\n--------------------------------------------");

		}
		//retorna a toString retorno com todos as string adicionada
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
