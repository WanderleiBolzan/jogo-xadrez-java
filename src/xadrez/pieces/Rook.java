package xadrez.pieces;

import boardgame.Board;
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
	
	
}
