import java.util.*;

public class Unit4Test{

    public static void main(String[] args){

    /*
        String str="CCCAAAT!";

        int maxStreak =0;
        int tempStreak=0;
        String maxChar="";
        String tempChar="";
        String currentCharStreak="";
        for (int i=0; i<str.length();i++){
            tempChar = str.substring(i,i+1);
            if(tempChar.equals(currentCharStreak)){
                tempStreak++;
                if (tempStreak>maxStreak){
                    maxStreak =tempStreak;
                    maxChar = tempChar;
                } // end if (code to update max counts )
            } else {
                currentCharStreak=tempChar;
                tempStreak=1;
            } // end of else
        } // end for loop
        System.out.println(maxChar+" "+maxStreak);
*/

        String str = "AP-CSA";
        for (int i = 0; i < str.length(); i++)
        {
            if (str.substring(i, i + 1).equals("A"))
            {
                System.out.print(i + " ");
            }
        }
        
    }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  



}