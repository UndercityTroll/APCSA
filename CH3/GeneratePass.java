import java.util.*;

public class GeneratePass{
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter first name: ");
        String firstName = myObj.nextLine();  // Read user input
        System.out.print("Enter last name: ");
        String lastName = myObj.nextLine();  // Read user input
        System.out.print("Enter age: ");
        int age = myObj.nextInt();  // Read user input
        String pass = generatePass(firstName, lastName, age);   
        System.out.println(pass);
    }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  

    public static String generatePass(String fname, String lname, int age){
        return fname.substring(0,3) + lname.substring(lname.length()-3,lname.length())+age;
    }
}