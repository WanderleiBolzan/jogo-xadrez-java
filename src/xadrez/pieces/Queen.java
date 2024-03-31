package xadrez.pieces;

import boardgame.Board;
import boardgame.Position;
import xadrez.ChassPiece;
import xadrez.Color;

public class Queen extends ChassPiece {

	public Queen(Board board, Color cor) {
		super(board, cor);		
	}

	@Override
	public String toString() {
		return "Q";
	}
	@Override
	public boolean[][] possibleMovies() {		
		boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		
		Position p = new Position(0, 0);
		// Criando o movimento para cima da peça Torre 
		p.setValues(position.getRows() - 1 , position.getColumns());
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setRows(p.getRows()-1);
		}
		if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// Criando o movimento para esquerda da peça Torre 
		p.setValues(position.getRows(), position.getColumns()-1);
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setColumns(p.getColumns()-1);
		}
		if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// Criando o movimento para esquerda da peça Torre 
		p.setValues(position.getRows(), position.getColumns()+1);
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setColumns(p.getColumns()+1);
		}
		if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// Criando o movimento para baixo da peça Torre 
		p.setValues(position.getRows() + 1, position.getColumns());
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setRows(p.getRows() + 1);
		}
		if (getTabuleiro().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		
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
