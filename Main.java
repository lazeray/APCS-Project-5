public class Main {
    public static void main(String[] args){
        Board board = new Board(7,15);
        Piece p1 = new Piece(13, 1, board);
        board.placePiece(p1);
        Piece p2 = new Piece(13, 2, board);
        board.placePiece(p1);
        board.placePiece(p2);

        board.displayAll();
    }
    public boolean validPlacement(boolean megaPiece, int col, Board board){
        return true;
    }
}