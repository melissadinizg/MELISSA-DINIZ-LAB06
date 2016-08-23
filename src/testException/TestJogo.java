/**
 * 
 */
package testException;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public class TestJogo {

		/**
		 * Metodo que testa a validade do nome do jogo
		 * 
		 * @param nome
		 * @throws Exception
		 */
		public static void testaNomeJogo(String nome) throws Exception {
			if (nome == null || nome.trim().equals("")) {
				throw new Exception("Nome do jogo nao pode ser vazio ou nulo.");
			}
		}
		
		/**
		 * Metodo que testa a validade do preco do jogo
		 * 
		 * @param nome
		 * @throws Exception
		 */
		public static void testaPrecoJogo(double preco) throws Exception {
			if (preco <= 0.0) {
				throw new Exception("Preco do jogo nao deve ser menor que zero.");
			}
		}
		
		/**
		 * Metodo que testa a validade do score
		 * 
		 * @param nome
		 * @throws Exception
		 */
		public static void testaScore(int score) throws Exception {
			if (score < 0) {
				throw new Exception("Score nao pode ser menor que 0.");
			}
		}
}
