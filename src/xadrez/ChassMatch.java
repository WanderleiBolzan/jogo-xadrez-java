package xadrez;

import boardgame.Board;
import boardgame.Position;
import xadrez.pieces.King;
import xadrez.pieces.Rook;

public class ChassMatch {
	
	Board board;
	
	public ChassMatch() {
		board = new Board(8, 8);
		initialSetup();
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

	private void initialSetup() {
		board.placePiece(new Rook(board, Color.BRANCO), new Position(2, 1));
		board.placePiece(new King(board, Color.PRETO), new Position(0, 4));		
		board.placePiece(new King(board, Color.BRANCO), new Position(7, 4));		
	}
}
