package jogo;

public enum Jogabilidade {
	
    OFFLINE("Offline"),ONLINE("Online"), COOPERATIVO("Cooperativo"), MULTIPLAYER("Multiplaye"), COMPETITIVO("Competitivo");
	
	private String tipoJogo;
	
	/**
	 * Construtor da jogabilidade
	 * @param tipoJogo
	 */
	Jogabilidade(String tipoJogo){
		this.tipoJogo = tipoJogo;
	}

	/**
	 * Recupera o tipo do jogo
	 * @return
	 */
	public String getTipoJogo() {
		return tipoJogo;
	}

	/**
	 * Altera o tipo do jogo
	 * @param tipoJogo
	 */
	public void setTipoJogo(String tipoJogo) {
		this.tipoJogo = tipoJogo;
	}
}
