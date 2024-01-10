import java.util.Scanner;
public class Main {
    static final int boardX = 7;
    static final int boardY = 15;
    public static void main(String[] args){
        System.out.println("Welcome to MEGA CONNECT 5!");
        System.out.println("You may choose to place one 3x3 megapiece");
        System.out.println();
        Board board = new Board(boardX,boardY);
        Scanner input = new Scanner(System.in); //creates scanner obj
        int player = 1;
        int[] remainingMegaPiece = new int[2]; // yucky implementation
        remainingMegaPiece[0] = 1;
        remainingMegaPiece[1] = 1;
        while(true) {
            board.displayAll();
            System.out.println("Player: " + player + ":");
            Piece p;
            String isMegapiece;
            if (remainingMegaPiece[player - 1] != 0){
                System.out.println("Use megapiece? (Y/N)?");
                isMegapiece = input.nextLine();
            }
            else{
                isMegapiece = "N";
            }
            if(isMegapiece.equalsIgnoreCase("Y")){
                System.out.println("Enter the column you would like to place your megapiece at.");
                String col = input.nextLine();
                if(!isValidCol(col, true)){
                    System.out.println("Not a valid piece placement.");
                    continue;
                }
                p = new MegaPiece(Integer.parseInt(col)-1, player, board);
                if(!isValidRow(p)){
                    System.out.println("Not a valid piece placement.");
                    continue;
                }
                board.placePiece(p);
                remainingMegaPiece[player-1]--;
            }
            else if(isMegapiece.equalsIgnoreCase("N")){
                System.out.println("Enter the column you would like to place your piece at.");
                String col = input.nextLine();
                if(!isValidCol(col, false)){
                    System.out.println("Not a valid piece placement.");
                    continue;
                }
                p = new Piece(Integer.parseInt(col)-1, player, board);
                if(!isValidRow(p)){
                    System.out.println("Not a valid piece placement.");
                    continue;
                }
                board.placePiece(p);
            }
            else{
                System.out.println("Please enter a valid answer");
                continue;
            }
            if(board.checkForWin(player)){
                System.out.println("player: " + player + " has won!");
                board.displayAll();
                break;
            }
            player=player%2+1;
        }



    }

    static public boolean isValidCol(String col, boolean isMegaPiece){
        if(!isMegaPiece&&(Integer.parseInt(col)<1||Integer.parseInt(col)>=boardY+1)){
            return false;
        }
        if(isMegaPiece&&(Integer.parseInt(col)<2||Integer.parseInt(col)>=boardY)){
            return false;
        }
        return true;
    }
    static public boolean isValidRow(Piece p){
        if(p.getRow()<0) {
            return false;
        }
        return true;
    }
}