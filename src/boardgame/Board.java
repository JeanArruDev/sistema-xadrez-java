package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1){
			throw new BoardException("O numero de linhas e colunas tem que ser maior que 0");
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
		if(!PositionExists(row, column)) {
			throw new BoardException("A posição passada não existe");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!PositionExists(position)) {
			throw new BoardException("A posição passada não existe");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void PlacePiece(Piece piece, Position position) {
		 if (ThereIsAPiece(position)) {
			 throw new BoardException("Já existe uma peça nessa posição" + position);
		 }
		 pieces[position.getRow()][position.getColumn()] = piece;
		 piece.position = position;
	}
	
	public boolean PositionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean PositionExists(Position position) {
		return PositionExists(position.getRow(), position.getColumn());
	}
	
	public boolean ThereIsAPiece(Position position) {
		if(!PositionExists(position)) {
			throw new BoardException("A posição passada não existe");
		}
		return piece(position) != null;
	}
}
