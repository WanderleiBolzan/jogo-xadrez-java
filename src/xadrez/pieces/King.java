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

}
