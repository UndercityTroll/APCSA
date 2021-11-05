public class RandomX{
    public static void main(String[] args){
        int x;
        do {
            x = (int)(Math.random()*16)+5;
            for (int i=0; i<x;i++){
                System.out.print("x");
            }
            System.out.println();
        } while (x != 16);
    }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  
}