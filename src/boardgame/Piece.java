package boardgame;

public class Piece {
	
	protected Position position;
	private Board board; // Cria uma Associação
	
	public Piece(Board board) {		
		this.board = board;
		position = null;
	}

	protected Board getTabuleiro() {
		return board;
	}

}
