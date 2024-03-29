package application;

import xadrez.ChassMatch;

public class Program {

	public static void main(String[] args) {	
		
		ChassMatch chassMatch = new  ChassMatch();
		UI.printBoard(chassMatch.getPieces());
		
	}

}
