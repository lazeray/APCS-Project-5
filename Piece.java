public class Piece {
    private int row;
    private int col;
    private int color; // 1 = X, 2 = O

    public Piece (int col, int color, Board board){
        this.col = col;
        this.row = findRow(col, board);
        System.out.println(row+" "+col);
        this.color = color;
    }

    private int findRow(int col, Board board){
        int[][] boardPieces = board.getBoardPieces();
        for(int y = 0; y<boardPieces.length-1; y++){
            if(boardPieces[y+1][col]!=0){
                return y;
            }
        }
        return boardPieces.length-1;
    }
    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public int getColor() {
        return color;
    }
}