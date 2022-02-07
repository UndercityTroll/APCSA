import java.util.*;

// Vikram Murugan
// Expands the card notation from QS to Queen of Spades

class Card{
    private static String[] classes = {"2","3","4","5","6","7","8","9","10","Ace","Jack","Queen","King","Diamonds","Hearts","Spades","Clubs"};
    
    //instance variables/ attributes
    private String notation;

    // constructors -> the exact same name as the class name
    public Card(){
        notation = "AS";
    }

    public Card(String notation){
        this.notation = notation;
    }

    // setter methods

    public void setNotation(String notation){
        this.notation = notation;
    }
    // getter methods

    public String getNotation(){
        return notation;
    }

    public String toString(){
        return notation;
    }

    // other methods
    public String getDescription(){

        String result = "";

        for (String str : classes){
            if (notation.substring(0,1).equals(str.substring(0,1))) {
                result += str;
            }
        }
        result += " of ";
        for (String str : classes){
            if ( notation.substring( notation.length()-1 ).equals( str.substring(0,1) ) ){
                result += str;
            }
        }
        return result;
    }

} // end of Bank account class


/// MAIN PUBLIC CLASS

public class CardTest{
    public static void main (String[] args){
        Card c = new Card("10C");
        System.out.println(c.getDescription());

    } // end of main

} // end of bank account test class