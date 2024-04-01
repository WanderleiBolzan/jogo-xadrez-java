package xadrez.pieces;

import boardgame.Board;
import boardgame.Position;
import xadrez.ChassMatch;
import xadrez.ChassPiece;
import xadrez.Color;

public class Pawn extends ChassPiece {
	
	private ChassMatch chessMatch;

	public Pawn(Board board, Color color,ChassMatch chessMatch ) {
		super(board, color);
		this.chessMatch = chessMatch;
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
			Position p2 = new Position(position.getRows()+1, position.getColumns());
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
			
			// Teste do passant peça Branca
			if (position.getRows() == 3) {
				Position left = new Position(position.getRows(),position.getColumns() -1);
				if(getTabuleiro().positionExists(left) && isThereOpponentPiece(left) && getTabuleiro().piece(left) == chessMatch.getEnPassantVunerable()) {
					mat[left.getRows() -1][left.getColumns()] = true;
				}
				// passant direita
				Position right = new Position(position.getRows(),position.getColumns() +1);
				if(getTabuleiro().positionExists(right) && isThereOpponentPiece(right) && getTabuleiro().piece(right) == chessMatch.getEnPassantVunerable()) {
					mat[right.getRows() -1][right.getColumns()] = true;
				}
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

			// Teste do passant peça Preta
			if (position.getRows() == 4) {
				Position left = new Position(position.getRows(),position.getColumns() -1);
				if(getTabuleiro().positionExists(left) && isThereOpponentPiece(left) && getTabuleiro().piece(left) == chessMatch.getEnPassantVunerable()) {
					mat[left.getRows() +1][left.getColumns()] = true;
				}
				// passant direita
				Position right = new Position(position.getRows(),position.getColumns() +1);
				if(getTabuleiro().positionExists(right) && isThereOpponentPiece(right) && getTabuleiro().piece(right) == chessMatch.getEnPassantVunerable()) {
					mat[right.getRows() +1][right.getColumns()] = true;
				}
			}

			
		}
			
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
