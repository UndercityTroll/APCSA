public class Test{
    // different print color constants
    public static final String ANSI_RESET  = "\u001B[0m";

    public static final String ANSI_BLACK  = "\u001B[30m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN   = "\u001B[36m";
    public static final String ANSI_WHITE  = "\u001B[37m";

    // dimensions of the board
    public static final int BOARD_WIDTH = 7;
    public static final int BOARD_HEIGHT = 5;

    // User and Computer Symbols
    public static final int USER_PIECE = 1;
    public static final int COMPUTER_PIECE = -1;

    // ----------------------------------------- MAIN METHOD -------------------------------------
	public static void main(String[] args){
		// define the main board
        int[][] mainBoard = boardSet();

        mainBoard = dropPiece(mainBoard, 2, USER_PIECE);
        mainBoard = dropPiece(mainBoard, 2, COMPUTER_PIECE);
		// define matrix
        printBoard(mainBoard);
        }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  

    
    /// initialize board state to all 0's
    public static int[][] boardSet(){
        // creates a 7 width by 5 height array initialized to zero
        int[][] board = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
        return board;
    }

    // code to print board to user each turn
    public static void printBoard(int[][] board){
        System.out.println();
        for (int i = 0; i<BOARD_HEIGHT;i++){
            for (int j = 0; j<BOARD_WIDTH;j++){
                if(board[i][j] == USER_PIECE){
                    System.out.print(ANSI_RED+"X ");
                } else if (board[i][j] == COMPUTER_PIECE){
                    System.out.print(ANSI_BLUE+"O ");
                } else{
                    System.out.print(ANSI_RESET+"- ");
                }
            }
            System.out.println(ANSI_RESET+"");
        }
        System.out.println("-------------");
        for (int j = 1; j<=7;j++){
            System.out.print(j+" ");
        }
    }

    // code to drop a piece after into a column
    public static int[][] dropPiece(int[][] board, int column, int piece){
        for (int i = (BOARD_HEIGHT-1); i>0; i--){
            if (board[i][column-1] == 0){
                board[i][column-1] = piece;
                return board;
            }
        }
        return board;
    }

}