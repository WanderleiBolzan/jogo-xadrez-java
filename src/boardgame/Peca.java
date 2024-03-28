package boardgame;

public class Peca {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro; // Cria uma Associação
	
	public Peca(Tabuleiro tabuleiro) {		
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}
