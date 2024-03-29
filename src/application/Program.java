package application;

import java.util.Scanner;

import xadrez.ChassMatch;
import xadrez.ChassPiece;
import xadrez.ChessPosition;

public class Program {

	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);	
		ChassMatch chassMatch = new  ChassMatch();
		
		while (true) {
			UI.printBoard(chassMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChassPiece capturedPiece = chassMatch.performChessMove(source, target);
			
		}

	}

}
