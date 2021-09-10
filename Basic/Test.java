public class Test{
	public static void main(String[] args){
		// define the main board
        //int[][] mainBoard = boardSet();

		// define matrix
        //printBoard(mainBoard);
        int a = 4;

        int b = 5;

        a++;

        b++;

        int c = a + b;

        a -= 1;

        System.out.println(a + c);
        }
    public static int[][] boardSet(){
        // creates a 7 width by 5 height array initialized to zero
        int[][] board = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
        return board;
    }
    public static void printBoard(int[][] board){
        System.out.println();
        for (int i = 0; i<5;i++){
            for (int j = 0; j<7;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------");
        for (int j = 1; j<=7;j++){
            System.out.print(j+" ");
        }
    }
}