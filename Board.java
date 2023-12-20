public class Board {
    private final int[][] boardPieces;
    public Board(int x, int y){
        boardPieces = new int[x][y];
    }
    public void placePiece(Piece p){
        boardPieces[p.getRow()][p.getCol()] = p.getColor();
    }


    public int[][] getBoardPieces() {
        return boardPieces;
    }

    public void displayAll(){
        for(int x = 0; x < boardPieces.length; x++){
            System.out.print("# ");
            for(int y = 0; y < boardPieces[0].length; y++){
                if(boardPieces[x][y]==0){ // no piece
                    System.out.print(". ");
                }
                if(boardPieces[x][y]==1){ // X piece
                    System.out.print("X ");
                }
                if(boardPieces[x][y]==2){ // O Piece
                    System.out.print("O ");
                }
            }
            System.out.println("#");
        }
        for(int y = 0; y < boardPieces[0].length+2; y++) { // creates the bottom layer of the board
            System.out.print("# ");
        }
    }

}