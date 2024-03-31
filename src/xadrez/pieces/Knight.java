package xadrez.pieces;

import boardgame.Board;
import boardgame.Position;
import xadrez.ChassPiece;
import xadrez.Color;

public class Knight extends ChassPiece {

	public Knight(Board board, Color cor) {
		super(board, cor);		
	}
	
	@Override
	public String toString() {
		return "N";
	}
	
	private boolean canMovie(Position position) {
		ChassPiece p = (ChassPiece) getTabuleiro().piece(position);
		return p == null || getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMovies() {		
		boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		
		Position p = new Position(0, 0);

		p.setValues(position.getRows()-1, position.getColumns()-2);
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		p.setValues(position.getRows()-2, position.getColumns()-1);
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		p.setValues(position.getRows()-2, position.getColumns()+1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		p.setValues(position.getRows()-1, position.getColumns()+2 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		p.setValues(position.getRows()+1 , position.getColumns()+1);
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		p.setValues(position.getRows()+2 , position.getColumns()+1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		p.setValues(position.getRows()+2 , position.getColumns()-1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		p.setValues(position.getRows()+1 , position.getColumns()-2 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		return mat;
	}

}
