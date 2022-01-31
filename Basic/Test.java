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

    // recursion depth
    public static final int RECURSION_DEPTH = 2;

    // User and Computer Symbols
    public static final int USER_PIECE = 1;      // user is   X
    public static final int COMPUTER_PIECE = -1; // computer is   O

    // ----------------------------------------- MAIN METHOD -------------------------------------
	public static void main(String[] args){
		// define the main board
        int[][] mainBoard = boardSet();

        // define score
        double[] score ={0,0,0,0};
        double[] inScore;

        // define scanner
         Scanner console = new Scanner(System.in);  // Create a Scanner object

         // define use input
         int input;

        // test gameplay
        for(int i=0;i<30;i++){
            inScore = computerRecurse(mainBoard,0,0);
            mainBoard = dropPiece(mainBoard, (int)inScore[4], COMPUTER_PIECE);
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
        int[][] tBoard = board;
        System.out.println("Inside Drop - tBoard:"+tBoard+" board:"+board);
        for (int i = (BOARD_HEIGHT-1); i>=0; i--){
            if (tBoard[i][column-1] == 0){
                tBoard[i][column-1] = piece;
                return tBoard;
            }
        }
        System.out.println("Inside Drop after - tBoard:"+tBoard+" board:"+board);
        return tBoard;
    }

    // Recursion Section
    public static double[] superScore(double[] score, int move){
        double[] temp = {0,0,0,0,0};
        for(int i = 0; i < 4; i++){
            temp[i] = score[i];
        }
        temp[4]= (double) move;
        return temp;
    }

    public static double[] computerRecurse(int[][] boardC, int depth, int move){
        double[] bestScore ={0.0,0.0,0.0,0.0,0.0};
        int[][] bestBoard = boardC;
        int[][] tempBoard = boardC;
        //printBoard(bestBoard, bestScore);
        //int[][][] boards = {board,board,board,board,board,board,board};
        depth++;
        //printBoard(bestBoard,score(bestBoard));
        if (depth <= RECURSION_DEPTH){
            for (int c = 1; c <= BOARD_WIDTH; c++){
                System.out.println("Depth: COMPUTER: "+depth+" column: "+c);
                tempBoard = boardC;
                tempBoard = dropPiece(boardC,c,COMPUTER_PIECE);
                //printBoard(tempBoard,score(tempBoard));
                double[] tempScore = userRecurse(tempBoard, depth, c);
                if (tempScore[2]>=bestScore[2]){
                    bestScore=tempScore;
                    System.out.println(" ----------------- best board c: "+c);
                    //printBoard(bestBoard, bestScore);
                }
            }
        } else {
            double[] t = score(boardC);
            bestScore = superScore(t, move);
        }
        System.out.println("C X:"+bestScore[0]+" O:"+bestScore[1]+" %:"+bestScore[2]+" W:"+bestScore[3]);
        //printBoard(bestBoard, bestScore);
        return bestScore;
    }


    public static double[] userRecurse(int[][] boardU, int depth, int move){
        double[] worstScore ={1.0,1.0,1.0,1.0,1.0};
        int[][] worstBoard = boardU;
        int[][] tempBoard = boardU;
        depth++;
        System.out.println(" --- "+depth+" - "+boardU);
        printBoard(worstBoard,score(worstBoard));
        if (depth <= RECURSION_DEPTH){
            for (int c = 1; c <= BOARD_WIDTH; c++){
                System.out.println("Depth: USER: "+depth+" column: "+c);
                System.out.println("User Recurse col:"+c+" "+tempBoard);
                tempBoard = boardU;
                System.out.println("Pre Drop");
                printBoard(tempBoard, score(tempBoard));
                tempBoard = dropPiece(boardU,c,USER_PIECE);
                System.out.println("Post Drop");
                printBoard(tempBoard, score(tempBoard));
                double[] tempScore = computerRecurse(tempBoard, depth, c);
                if (tempScore[2]<=worstScore[2]){
                    worstScore=tempScore;
                    System.out.println(" ----------------- worst score: "+c);
                    
                }
            }
        } else {
            double[] t = score(boardU);
            worstScore = superScore(t, move);
        }

        //System.out.println(" END OF THE USER CASE--------------------------------------------------------");
        //System.out.println("U X:"+worstScore[0]+" O:"+worstScore[1]+" %:"+worstScore[2]+" W:"+worstScore[3]);
        //printBoard(worstBoard, worstScore);
        
        //System.out.println(" END OF THE USER CASE--------------------------------------------------------");
        return worstScore;
    }


















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
                        sum +=  [r][c+i];
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