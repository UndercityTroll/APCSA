import java.util.*;

// Vikram Murugan
// takes in a string
// splits string into doubles
// finds the largest double
// takes 3 doubles and returns the largest

public class Largest {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter three numbers: ");
        float[] nums = {reader.nextFloat(), reader.nextFloat(), reader.nextFloat()};
        float max = nums[0];
        for (float i : nums) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }
}
