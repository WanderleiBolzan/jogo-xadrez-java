package xadrez.pieces;

import boardgame.Board;
import boardgame.Position;
import xadrez.ChassPiece;
import xadrez.Color;

public class Rook extends ChassPiece {

	public Rook(Board board, Color cor) {
		super(board, cor);		
	}

	@Override
	public String toString() {
		return "R";
	}
	@Override
	public boolean[][] possibleMovies() {		
		boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		
		Position p = new Position(0, 0);
		// Criando o movimento para cima da peça Torre 
		p.setValues(position.getRows() - 1 , position.getColumns());
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereisAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setRows(p.getRows()-1);
		}
		if (getTabuleiro().positionExists(p) && isThereOponentPeace(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// Criando o movimento para esquerda da peça Torre 
		p.setValues(position.getRows(), position.getColumns()-1);
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereisAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setColumns(p.getColumns()-1);
		}
		if (getTabuleiro().positionExists(p) && isThereOponentPeace(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// Criando o movimento para esquerda da peça Torre 
		p.setValues(position.getRows(), position.getColumns()+1);
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereisAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setColumns(p.getColumns()+1);
		}
		if (getTabuleiro().positionExists(p) && isThereOponentPeace(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}

		// Criando o movimento para baixo da peça Torre 
		p.setValues(position.getRows() + 1, position.getColumns());
		while (getTabuleiro().positionExists(p) && !getTabuleiro().thereisAPiece(p)) {
			mat[p.getRows()][p.getColumns()] = true;
			p.setRows(p.getRows() + 1);
		}
		if (getTabuleiro().positionExists(p) && isThereOponentPeace(p)) {
			mat[p.getRows()][p.getColumns()] = true;
		}
		
		
		return mat;
	}
	
	
}
