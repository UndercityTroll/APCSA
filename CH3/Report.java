import java.util.*;

public class Report{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int[] stores = {0,0,0,0};
        for (int i = 0; i< 5; i++){
            System.out.print("Enter today's profit for store "+i+": ");
            stores[i] = (int)(((double)myObj.nextInt())/100.0);  // Read user input
        }
        System.out.println();
        System.out.println("Sales Bar Chart");
        System.out.println("Each * = $100");

        for(int i=0;i<5;i++) print(stores[i]);

    }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  

    

    public static void print(int length){
        for(int i=0;i<length;i++) System.out.print("*");
        System.out.println();
    }
}