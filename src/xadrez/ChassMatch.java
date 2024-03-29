package xadrez;

import boardgame.Board;

public class ChassMatch {
	
	Board board;
	
	public ChassMatch() {
		board = new Board(8, 8);
	}
	
	public ChassPiece[][] getPieces() {
		ChassPiece[][] mat = new ChassPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChassPiece) board.piece(i, j);
			}
		}
		return mat;
	}

}
