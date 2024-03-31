package xadrez.pieces;

import boardgame.Board;
import boardgame.Position;
import xadrez.ChassPiece;
import xadrez.Color;

public class Pawn extends ChassPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMovies() {		
		boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];

		Position p = new Position(0, 0);
		
		if (getColor() == Color.BRANCO) {
			p.setValues(position.getRows()-1, position.getColumns());
			if (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
				mat[p.getRows()][p.getColumns()] = true;
			}
			// Testando o primeiro movimento do pião
			p.setValues(position.getRows()-2, position.getColumns());
			Position p2 = new Position(position.getRows()-1, position.getColumns());
			if (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p) && getTabuleiro().positionExists(p2) && !getTabuleiro().thereIsAPiece(p2) && getMoveCount() == 0 ) {
				mat[p.getRows()][p.getColumns()] = true;
			}
			p.setValues(position.getRows()-1, position.getColumns()-1 );
			if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRows()][p.getColumns()] = true;
			}
			p.setValues(position.getRows()-1, position.getColumns()+1 );
			if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRows()][p.getColumns()] = true;
			}
		}
		else {
			p.setValues(position.getRows()+1, position.getColumns());
			if (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
				mat[p.getRows()][p.getColumns()] = true;
			}
			// Testando o primeiro movimento do pião
			p.setValues(position.getRows()+2, position.getColumns());
			Position p2 = new Position(position.getRows() - 1, position.getColumns());
			if (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p) && getTabuleiro().positionExists(p2) && !getTabuleiro().thereIsAPiece(p2) && getMoveCount() == 0 ) {
				mat[p.getRows()][p.getColumns()] = true;
			}
			p.setValues(position.getRows()+1, position.getColumns()-1 );
			if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRows()][p.getColumns()] = true;
			}
			p.setValues(position.getRows()+1, position.getColumns()+1 );
			if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRows()][p.getColumns()] = true;
			}
			
		}
			
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
