package xadrez;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import xadrez.pieces.King;
import xadrez.pieces.Rook;

public class ChassMatch {
	
	private int turn;
	private Color currentPlayer;
	private Board board;
	
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
	
	public ChassPiece[][] getPieces() {
		ChassPiece[][] mat = new ChassPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChassPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	public boolean[][] possibleMovies (ChessPosition sourcePosition) {
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
		nextTurn();
		return (ChassPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if(capturedPiece !=null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereisAPiece(position)) {
			throw new ChessException("Não há peça nessa posição");
		}
		if (currentPlayer != ((ChassPiece)board.piece(position)).getCor()) {
			throw new ChessException("A peça escolhida não é sua");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Não existe movimentos possíveis para a peça escolhida");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMovie(target)) {
			throw new ChessException("A peça escolhida não pode ser movida para o destino desejado");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.BRANCO) ? Color.PRETO : Color.BRANCO;
	}
	
	private void placeNewPiece(char column, int row, ChassPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.BRANCO));
        placeNewPiece('c', 2, new Rook(board, Color.BRANCO));
        placeNewPiece('d', 2, new Rook(board, Color.BRANCO));
        placeNewPiece('e', 2, new Rook(board, Color.BRANCO));
        placeNewPiece('e', 1, new Rook(board, Color.BRANCO));
        placeNewPiece('d', 1, new King(board, Color.BRANCO));

        placeNewPiece('c', 7, new Rook(board, Color.PRETO));
        placeNewPiece('c', 8, new Rook(board, Color.PRETO));
        placeNewPiece('d', 7, new Rook(board, Color.PRETO));
        placeNewPiece('e', 7, new Rook(board, Color.PRETO));
        placeNewPiece('e', 8, new Rook(board, Color.PRETO));
        placeNewPiece('d', 8, new King(board, Color.PRETO));	}
}
