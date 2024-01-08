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
    public boolean checkForWin(int player){
        for(int x = 0; x<boardPieces.length; x++){
            for(int y = 0; y<boardPieces[0].length; y++){
                if(checkDirection(x,y,0,1,player)||checkDirection(x,y,1,0,player)||checkDirection(x,y,1,-1,player)||checkDirection(x,y,1,1,player)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int rowDirection, int colDirection, int player) {
        for (int i = 0; i < 5; i++) {
            int newRow = row + i * rowDirection;
            int newCol = col + i * colDirection;
            if (!isValidPosition(newRow, newCol) || boardPieces[newRow][newCol] != player) {
                return false;
            }
        }
        return true;
    }
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < boardPieces.length && col >= 0 && col < boardPieces[0].length;
    }

}
