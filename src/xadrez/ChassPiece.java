package xadrez;

import boardgame.Piece;
import boardgame.Board;

public abstract class ChassPiece extends Piece {
	
	private Color cor;

	public ChassPiece(Board board, Color cor) {
		super(board);
		this.cor = cor;
	}

	public Color getCor() {
		return cor;
	}

}
