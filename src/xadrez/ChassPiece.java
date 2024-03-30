package xadrez;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChassPiece extends Piece {
	
	private Color cor;

	public ChassPiece(Board board, Color cor) {
		super(board);
		this.cor = cor;
	}

	public Color getCor() {
		return cor;
	}

	protected boolean isThereOponentPeace(Position position) {
		ChassPiece p = (ChassPiece) getTabuleiro().piece(position);
		return p != null && p.getCor() != cor;
	}
	
}
