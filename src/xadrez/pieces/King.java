package xadrez.pieces;

import boardgame.Board;
import boardgame.Position;
import xadrez.ChassPiece;
import xadrez.Color;

public class King extends ChassPiece {

	public King(Board board, Color cor) {
		super(board, cor);		
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMovie(Position position) {
		ChassPiece p = (ChassPiece) getTabuleiro().piece(position);
		return p == null || getCor() != getCor();
	}

	@Override
	public boolean[][] possibleMovies() {		
		boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		
		Position p = new Position(0, 0);
		
		// movimento para cima
		p.setValues(position.getRows() - 1, position.getColumns());
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		
		// movimento para baixo
		p.setValues(position.getRows() + 1, position.getColumns());
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// movimento para esquerda
		p.setValues(position.getRows(), position.getColumns()-1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		// movimento para direita
		p.setValues(position.getRows(), position.getColumns()+1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// movimento para diagonal esquerda
		p.setValues(position.getRows()-1 , position.getColumns()-1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// movimento para diagonal direita
		p.setValues(position.getRows()-1 , position.getColumns()+1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		// movimento para diagonal abaixo a esquerda
		p.setValues(position.getRows()+1 , position.getColumns()-1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		// movimento para diagonal abaixo a direita
		p.setValues(position.getRows()+1 , position.getColumns()+1 );
		if (getTabuleiro().positionExists(p) && canMovie(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		
		
		return mat;
	}

}
