import java.util.Scanner;

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
    public static final int WIN_STATE = 4;

    // User and Computer Symbols
    public static final int USER_PIECE = 1;      // user is   X
    public static final int COMPUTER_PIECE = -1; // computer is   O

    // ----------------------------------------- MAIN METHOD -------------------------------------
	public static void main(String[] args){
		// define the main board
        int[][] mainBoard = boardSet();

        // define score
        double[] score ={0,0,0,0};

        // define scanner
         Scanner console = new Scanner(System.in);  // Create a Scanner object

         // define use input
         int input;

        // test gameplay
        for(int i=0;i<30;i++){
            mainBoard = dropPiece(mainBoard, (int)(Math.random()*7.0+1), COMPUTER_PIECE);
            score = score(mainBoard);
            printBoard(mainBoard, score);
            if (score[3]!=0){
                System.out.println("win");
                break;
            }
            mainBoard = getInput(mainBoard, console);
            score = score(mainBoard);
            printBoard(mainBoard, score);
            if (score[3]!=0){
                System.out.println("win");
                break;
            }
        }
        
    }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  


    public static int[][] getInput(int[][] board, Scanner console){
        System.out.print("which column do you want to drop the piece into: ");
        int user = console.nextInt();
        return  dropPiece(board, user, USER_PIECE);
    }
    
    /// initialize board state to all 0's
    public static int[][] boardSet(){
        // creates a 7 width by 5 height array initialized to zero
        int[][] board = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
        return board;
    }

    // code to print board to user each turn
    public static void printBoard(int[][] board, double[] score){
        System.out.println();
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
        System.out.println();
        System.out.println("X:"+score[0]+" O:"+score[1]+" %:"+(100-Math.round((score[2]*100)))+" ");
        System.out.println("Win state : "+score[3]);
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

// Recursion Section






















    // return board score
    public static double [] score(int[][] board){
        double[] score = {0,0,0,0};
        int sum = 0;
        // --------------------------------- vertical  --------------------------------- 

        //System.out.println("for loop start");
        for(int p = 2; p <= WIN_STATE; p ++){
            //for every point value   
            for(int c = 0; c < BOARD_WIDTH; c ++){
                //for every column
                for(int r = 0; r < (BOARD_HEIGHT-p+1); r ++){
                    // for every row
                    // find the sum of all digits in selection
                    for(int i = 0; i < p; i++){
                        sum += board[r+i][c];
                    }
                    // if uninterupted then added to score
                    if (sum == p){
                        score[0] += Math.pow(2,p*p);
                        if (p==4){
                            score[3] = 1;
                        }
                        //System.out.println("score 0:  "+score[0]+"| ["+r+"]["+c+"]");
                    } else if (sum == p*-1){
                        score[1] += Math.pow(2,p*p);
                        //System.out.println("score 1:  "+score[1]+"| ["+r+"]["+c+"]");
                        if (p==4){
                            score[3] = -1;
                        }
                    }
                    sum = 0;
                }    
            }
        }
        // --------------------------------- horizontal--------------------------------- 
        for(int p = 2; p <= WIN_STATE; p ++){
            //for every point value   
            for(int r = 0; r < BOARD_HEIGHT; r ++){
                //for every column
                for(int c = 0; c < (BOARD_WIDTH-p+1); c ++){
                    // for every row
                    // find the sum of all digits in selection
                    for(int i = 0; i < p; i++){
                        sum += board[r][c+i];
                    }
                    // if uninterupted then added to score
                    if (sum == p){
                        score[0] += Math.pow(2,p*p);
                        if (p==4){
                            score[3] = 1;
                        }
                        //System.out.println("score 0:  "+score[0]+"| ["+r+"]["+c+"]");
                    } else if (sum == p*-1){
                        score[1] += Math.pow(2,p*p);
                        if (p==4){
                            score[3] = -1;
                        }
                        //System.out.println("score 1:  "+score[1]+"| ["+r+"]["+c+"]");
                    }
                    sum = 0;
                }    
            }
        }
        // --------------------------------- diagonal \ --------------------------------- 
        for(int p = 2; p <= WIN_STATE; p ++){
            //for every point value   
            for(int r = 0; r < (BOARD_HEIGHT-p+1); r ++){
                //for every column
                for(int c = 0; c < (BOARD_WIDTH-p+1); c ++){
                    // for every row
                    // find the sum of all digits in selection
                    for(int i = 0; i < p; i++){
                        sum += board[r+i][c+i];
                        //System.out.println("["+(r+i)+"]["+(c+i)+"] = "+board[r+i][c+i]);
                    }
                    // if uninterupted then added to score
                    if (sum == p){
                        score[0] += Math.pow(2,p*p);
                        if (p==4){
                            score[3] = 1;
                        }
                        //System.out.println("D \\ score 0:  "+score[0]+"| ["+r+"]["+c+"]");
                    } else if (sum == p*-1){
                        score[1] += Math.pow(2,p*p);
                        if (p==4){
                            score[3] = -1;
                        }
                        //System.out.println("D \\ score 1:  "+score[1]+"| ["+r+"]["+c+"]");
                    }
                    sum = 0;
                }    
            }
        }
        // --------------------------------- diagonal / --------------------------------- 
        for(int p = 2; p <= WIN_STATE; p ++){
            //for every point value   
            for(int r = 0; r < (BOARD_HEIGHT-p+1); r ++){
                //for every column
                for(int c = 0; c < (BOARD_WIDTH-p+1); c ++){
                    // for every row
                    // find the sum of all digits in selection
                    for(int i = 0; i < p; i++){
                        sum += board[r+i][c+p-i-1];
                        //System.out.println("["+(r+i)+"]["+(c+p-i-1)+"] = "+board[r+i][c+p-i-1]);
                    }
                    // if uninterupted then added to score
                    if (sum == p){
                        score[0] += Math.pow(2,p*p);
                        if (p==4){
                            score[3] = 1;
                        }
                        //System.out.println("D / score 0:  "+score[0]+"| ["+r+"]["+c+"]["+p+"]");
                    } else if (sum == p*-1){
                        score[1] += Math.pow(2,p*p);
                        if (p==4){
                            score[3] = -1;
                        }
                        //System.out.println("D / score 1:  "+score[1]+"| ["+r+"]["+c+"]["+p+"]");
                    }
                    sum = 0;
                }    
            }
        }
        // setting the win percent
        if (score[3]==-1){
            score[2] = 1;
        } else if (score[3]==1)  {
            score[2] = 0;
        } else {
            score[2] = score[1]/(score[0]+score[1]);
        }
        return score;
    }
}