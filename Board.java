public class Board {
    private final int[][] boardPieces;
    public Board(int x, int y){
        boardPieces = new int[x][y];
    }
    public void placePiece(Piece p){
        if(p instanceof MegaPiece){
            for(int i = p.getRow()-1; i<p.getRow()+2; i++){
                for(int z = p.getCol()-1; z < p.getCol()+2; z++){
                    boardPieces[i][z] = p.getColor();
                }
            }
        }
        else {
            boardPieces[p.getRow()][p.getCol()] = p.getColor();
        }
    }


    public int[][] getBoardPieces() {
        return boardPieces;
    }

    public void displayAll(){
        System.out.print("   ");
        for(int y = 0; y < 9; y++) { // creates the column layer of the board
            System.out.print((y+1)+"  ");
        }
        for(int y = 9; y < boardPieces[0].length; y++) {
            System.out.print((y+1)+" ");
        }
        System.out.println();
        for(int x = 0; x < boardPieces.length; x++){
            System.out.print("#  ");
            for(int y = 0; y < boardPieces[0].length; y++){
                if(boardPieces[x][y]==0){ // no piece
                    System.out.print(".  ");
                }
                if(boardPieces[x][y]==1){ // X piece
                    System.out.print("X  ");
                }
                if(boardPieces[x][y]==2){ // O Piece
                    System.out.print("O  ");
                }
            }
            System.out.println("#");
        }
        for(int y = 0; y < boardPieces[0].length+2; y++) { // creates the bottom layer of the board
            System.out.print("#  ");
        }
        System.out.println();
    }
    public boolean checkForWin(){ // FIXME
        return false;
    }

}