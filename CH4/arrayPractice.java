import java.util.*;

public class arrayPractice{
    public static void main(String[] args){
        int[] temps = {32,98,73,100,65};
        double average = average(temps);
        System.out.println("average: "+average);
        System.out.println("how many above average: "+aboveDouble(temps, average));
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