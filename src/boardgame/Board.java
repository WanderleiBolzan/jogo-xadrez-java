package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro: É necessário que haja pelo menos 1 linha e 1 coluna");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Essa posição não existe no Tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {

		if (!positionExists(position)) {
			throw new BoardException("Essa posição não existe no Tabuleiro");
		}
		return pieces[position.getRows()][position.getColumns()];
	}
	
	public void placePiece(Piece piece, Position position) {
		
		if (thereisAPiece(position)) {
			throw new BoardException("Já existe uma peça nessa posição" + position);
		}
		
		pieces[position.getRows()][position.getColumns()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position posicao) {
		if (!positionExists(posicao)) {
			throw new BoardException("Essa posição não existe no Tabuleiro");
		}
		if(piece(posicao) == null) {
			return null ;
		}
		Piece aux = piece(posicao);
		aux.position = null;
		pieces[posicao.getRows()][posicao.getColumns()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRows(), position.getColumns());
	}
	
	public boolean thereisAPiece(Position position) {
		
		if (!positionExists(position)) {
			throw new BoardException("Essa posição não existe no tabuleiro");
		}
		
		return piece(position) != null;
	}
}
