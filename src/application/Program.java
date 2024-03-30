package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ChassMatch;
import xadrez.ChassPiece;
import xadrez.ChessException;
import xadrez.ChessPosition;

public class Program {

	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);	
		ChassMatch chassMatch = new  ChassMatch();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chassMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibileMovies = chassMatch.possibleMovies(source);
				UI.clearScreen();
				UI.printBoard(chassMatch.getPieces(), possibileMovies);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChassPiece capturedPiece = chassMatch.performChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}

	}

}
