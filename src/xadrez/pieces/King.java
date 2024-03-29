package xadrez.pieces;

import boardgame.Board;
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

	@Override
	public boolean[][] possibleMovies() {		
		boolean[][] mat = new boolean[getTabuleiro().getRows()][getTabuleiro().getColumns()];
		return mat;
	}

}
