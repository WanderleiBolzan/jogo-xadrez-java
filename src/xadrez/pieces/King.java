package xadrez.pieces;

import boardgame.Board;
import boardgame.Position;
import xadrez.ChassMatch;
import xadrez.ChassPiece;
import xadrez.Color;

public class King extends ChassPiece {
	
	private ChassMatch chessmatch;

	public King(Board board, Color cor, ChassMatch chessmatch) {
		super(board, cor);		
		this.chessmatch = chessmatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMovie(Position position) {
		ChassPiece p = (ChassPiece) getTabuleiro().piece(position);
		return p == null || getColor() != getColor();
	}

	private boolean testRockCastling(Position position) {
		ChassPiece p = (ChassPiece)getTabuleiro().piece(position);
		return p !=null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
		// Teste para o movimento Rock()
		if (getMoveCount() == 0 && !chessmatch.getCheck()) {
			// Rock Pequeno
			Position posT1 = new Position(position.getRows(), position.getColumns() + 3);
			if (testRockCastling(posT1)) {
				Position p1 = new Position(position.getRows(), position.getColumns() + 1);
				Position p2 = new Position(position.getRows(), position.getColumns() + 2);
				if (getTabuleiro().piece(p1) == null && getTabuleiro().piece(p2) == null) {
					mat[position.getRows()][position.getColumns() + 2] = true;
				}
			}	
			// Rock Grande
			Position posT2 = new Position(position.getRows(), position.getColumns() - 4);
			if (testRockCastling(posT2)) {
				Position p1 = new Position(position.getRows(), position.getColumns() - 1);
				Position p2 = new Position(position.getRows(), position.getColumns() - 2);
				Position p3 = new Position(position.getRows(), position.getColumns() - 3);				
				if (getTabuleiro().piece(p1) == null && getTabuleiro().piece(p2) == null && getTabuleiro().piece(p3) == null) {
					mat[position.getRows()][position.getColumns() - 2] = true;
				}
			}				
		}
		return mat;
	}
}
