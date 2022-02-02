package boardgame;

public class Board {
	
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board() {
	}

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1 ) {
			throw new BoardException("Erro criando o tabuleiro: É necessário que haja pelo menos 1 linha e 1 coluna!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExistis(row, column)) {
			throw new BoardException("A posição não está no tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExistis(position)) {
			throw new BoardException("A posição não está no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça dessa posição");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExistis(position)) {
			throw new BoardException("A posição não está no tabuleiro");
		} if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExistis(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExistis(Position position) {
		return positionExistis(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExistis(position)) {
			throw new BoardException("A posição não está no tabuleiro");
		}
		return piece(position) != null;
	}
	
}

