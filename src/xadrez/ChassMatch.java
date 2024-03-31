package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import xadrez.pieces.Bishop;
import xadrez.pieces.King;
import xadrez.pieces.Pawn;
import xadrez.pieces.Rook;

public class ChassMatch {

	private int turn;
	private Color currentPlayer;
	private Board board;
	private boolean check;
	private boolean checkMate;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	public ChassMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.BRANCO;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return checkMate;
	}
	
	public ChassPiece[][] getPieces() {
		ChassPiece[][] mat = new ChassPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChassPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMovies();
	}
	
	public ChassPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		
		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put yourself in check");
		}
		
		check = (testCheck(opponent(currentPlayer))) ? true : false;

		if (testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		}
		else {
			nextTurn();
		}
		
		return (ChassPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		ChassPiece p = (ChassPiece) board.removePiece(source);
		p.increaseMoveCount();
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		ChassPiece p = (ChassPiece) board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p, source);
		
		if (capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if (currentPlayer != ((ChassPiece)board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMovie(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.BRANCO) ? Color.BRANCO : Color.BRANCO;
	}
	
	private Color opponent(Color color) {
		return (color == Color.BRANCO) ? Color.BRANCO : Color.BRANCO;
	}
	
	private ChassPiece king(Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChassPiece)x).getColor() == color).collect(Collectors.toList());
		for (Piece p : list) {
			if (p instanceof King) {
				return (ChassPiece)p;
			}
		}
		throw new IllegalStateException("There is no " + color + " king on the board");
	}
	
	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChassPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMovies();
			if (mat[kingPosition.getRows()][kingPosition.getColumns()]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {
			return false;
		}
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChassPiece)x).getColor() == color).collect(Collectors.toList());
		for (Piece p : list) {
			boolean[][] mat = p.possibleMovies();
			for (int i=0; i<board.getRows(); i++) {
				for (int j=0; j<board.getColumns(); j++) {
					if (mat[i][j]) {
						Position source = ((ChassPiece)p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = makeMove(source, target);
						boolean testCheck = testCheck(color);
						undoMove(source, target, capturedPiece);
						if (!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}	
	
	private void placeNewPiece(char column, int row, ChassPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
        placeNewPiece('a', 1, new Rook(board, Color.BRANCO));
        placeNewPiece('c', 1, new Bishop(board, Color.BRANCO));
        placeNewPiece('e', 1, new King(board, Color.BRANCO));
        placeNewPiece('f', 1, new Bishop(board, Color.BRANCO));        
        placeNewPiece('h', 1, new Rook(board, Color.BRANCO));
        placeNewPiece('a', 2, new Pawn(board, Color.BRANCO));
        placeNewPiece('b', 2, new Pawn(board, Color.BRANCO));
        placeNewPiece('c', 2, new Pawn(board, Color.BRANCO));
        placeNewPiece('d', 2, new Pawn(board, Color.BRANCO));
        placeNewPiece('e', 2, new Pawn(board, Color.BRANCO));
        placeNewPiece('f', 2, new Pawn(board, Color.BRANCO));        
        placeNewPiece('g', 2, new Pawn(board, Color.BRANCO));        
        placeNewPiece('h', 2, new Pawn(board, Color.BRANCO));
        
        placeNewPiece('a', 8, new Rook(board, Color.PRETO));
        placeNewPiece('c', 8, new Bishop(board, Color.PRETO));        
        placeNewPiece('e', 8, new King(board, Color.PRETO));
        placeNewPiece('f', 8, new Bishop(board, Color.PRETO));        
        placeNewPiece('h', 8, new Rook(board, Color.PRETO));
        placeNewPiece('a', 7, new Pawn(board, Color.PRETO));        
        placeNewPiece('b', 7, new Pawn(board, Color.PRETO));
        placeNewPiece('c', 7, new Pawn(board, Color.PRETO));
        placeNewPiece('d', 7, new Pawn(board, Color.PRETO));
        placeNewPiece('e', 7, new Pawn(board, Color.PRETO));
        placeNewPiece('f', 7, new Pawn(board, Color.PRETO));
        placeNewPiece('g', 7, new Pawn(board, Color.PRETO));
        placeNewPiece('h', 7, new Pawn(board, Color.PRETO));        
        
        
	}
}