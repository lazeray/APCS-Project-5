import java.util.Scanner;
public class Main {
    static final int boardX = 7;
    static final int boardY = 15;
    public static void main(String[] args){
        System.out.println("Welcome to MEGA CONNECT 5!");
        System.out.println();
        Board board = new Board(boardX,boardY);
        Scanner input = new Scanner(System.in); //creates scanner obj
        int player = 1;
        while(true){
            board.displayAll();
            System.out.println("Player: " + player + ":");
            System.out.println("Use megapiece? (Y/N)?");
            String isMegapiece = input.nextLine();
            Piece p;
            if(isMegapiece.equalsIgnoreCase("Y")){
                System.out.println("Enter the column you would like to place your megapiece at.");
                String col = input.nextLine();
                if(Integer.parseInt(col)<2||Integer.parseInt(col)>=boardY){
                    System.out.println("Not a valid piece placement.");
                    continue;
                }
                p = new MegaPiece(Integer.parseInt(col)-1, player, board);
                if(!isValidRow(p)){
                    System.out.println("Not a valid piece placement.");
                    continue;
                }
                if(1==1){ //FIXME for checking player.megapiececount

                }
                board.placePiece(p);
            }
            else if(isMegapiece.equalsIgnoreCase("N")){
                System.out.println("Enter the column you would like to place your piece at.");
                String col = input.nextLine();
                if(Integer.parseInt(col)<1||Integer.parseInt(col)>=boardY+1){
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
            player=player%2+1;
        }



    }
    static public boolean isValidRow(Piece p){
        if(p.getRow()<0) {
            return false;
        }
        return true;
    }
}