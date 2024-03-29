package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board; // Cria uma Associação
	
	public Piece(Board board) {		
		this.board = board;
		position = null;
	}

	protected Board getTabuleiro() {
		return board;
	}
	
	public abstract boolean[][] possibleMovies();
	
	public boolean possibleMovie(Position position) {
		return possibleMovies() [position.getRows()][position.getColumns()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMovies();
		for (int i = 0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}			
			}
		}
		return false;
	}

}
