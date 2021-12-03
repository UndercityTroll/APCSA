import java.util.*;

public class arrayPractice2{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        System.out.print("How many employees do you have: ");
        int arrayLength = console.nextInt();
        System.out.println();

        arrayMain = new int[arrayLength];
        max = Integer.MIN_VALUE
        min = Integer.MAX_VALUE;

        for (int i : arrayMain){
            System.out.print("Income for Employee :");
            i = console.nextInt();
            System.out.println();
            if (i>=max) max == i;
            if (i<=min) min ==i;
        }

        System.out.println();
        System.out.println("max: $"+max);
        System.out.println("min: $"+min);
    }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  

    public static double average(int[] array){
        int sum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++){
            sum += array[i];
        }
        return (double) sum/length;    
    }

    public static int aboveDouble(int[] array, double number){
        int sum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++){
            if (array[i]>number){
                sum++;
            }
        }
        return sum;  
    }


}