package xadrez.pieces;

import boardgame.Board;
import boardgame.Position;
import xadrez.ChassPiece;
import xadrez.Color;

public class Bishop extends ChassPiece {

	
	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMovies() {		
		boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		
		Position p = new Position(0, 0);
		// nw  (Noroeste)
		p.setValues(position.getRows() - 1 , position.getColumns()-1);
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setValues(p.getRows()-1 , p.getColumns()-1);
		}
		if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// ne - Nordeste
		p.setValues(position.getRows()-1, position.getColumns()+1);
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setValues(p.getRows()-1, p.getColumns()+1);
		}
		if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// se - Sudeste
		p.setValues(position.getRows()+1, position.getColumns()+1);
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setValues(p.getRows(), p.getColumns()+1);
		}
		if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// sw - Sudoeste
		p.setValues(position.getRows() - 1, position.getColumns()+1);
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setValues(p.getRows()+1, p.getColumns()-1);
		}
		if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		return mat;
	}
}
