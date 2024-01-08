public class Piece {
    private int row;
    private int col;
    private int color; // 1 = X, 2 = O

    public Piece (int col, int color, Board board){ // set row bad!
        this.col = col;
        this.row = findRow(col, board);
        this.color = color;
    }

    private int findRow(int col, Board board){
        int[][] boardPieces = board.getBoardPieces();
        if(this instanceof MegaPiece){
            for(int y = -1; y< boardPieces.length-2; y++){
                if(boardPieces[y+2][col-1]!=0||boardPieces[y+2][col]!=0||boardPieces[y+2][col+1]!=0){
                    return y;
                }
            }
            return boardPieces.length-2;
        }
        else{
            for(int y = -1; y<boardPieces.length-1; y++){
                if(boardPieces[y+1][col]!=0){
                    return y;
                }
            }
            return boardPieces.length-1;
        }
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