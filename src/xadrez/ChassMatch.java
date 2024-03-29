package xadrez;

import boardgame.Board;
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

	private void placeNewPiece(char column, int row, ChassPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		
	}
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.BRANCO));
        placeNewPiece('c', 2, new Rook(board, Color.BRANCO));
        placeNewPiece('d', 2, new Rook(board, Color.BRANCO));
        placeNewPiece('e', 2, new Rook(board, Color.BRANCO));
        placeNewPiece('e', 1, new Rook(board, Color.BRANCO));
        placeNewPiece('d', 1, new King(board, Color.BRANCO));

        placeNewPiece('c', 7, new Rook(board, Color.PRETO));
        placeNewPiece('c', 8, new Rook(board, Color.PRETO));
        placeNewPiece('d', 7, new Rook(board, Color.PRETO));
        placeNewPiece('e', 7, new Rook(board, Color.PRETO));
        placeNewPiece('e', 8, new Rook(board, Color.PRETO));
        placeNewPiece('d', 8, new King(board, Color.PRETO));	}
}
