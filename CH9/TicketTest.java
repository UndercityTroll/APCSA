/*
 * Vikram Murugan
 * Period 6
 * Ticket Class Page623 #4-7
 * This class is for tickets for a show and setting prices based on dates
 * */
 

//Tester class with main
public class TicketTest {
    public static void main(String args[]) {
        //WALKUP TICKET TEST
        Ticket t1 = new WalkupTicket(75987);
        System.out.println(t1);
        //should print "Number: 75987, Price: $50.0"

        //ADVANCE TICKET TEST: LESS THAN TEN DAYS IN ADVANCE
        Ticket t2 = new AdvanceTicket(14234, 3);
        System.out.println(t2);
        //should print "Number: 14234, Price: $40.0"

        //ADVANCE TICKET TEST: GREATER THAN TEN DAYS IN ADVANCE
        Ticket t3 = new AdvanceTicket(9223557, 15);
        System.out.println(t3);
        //should print "Number: 9223557, Price: $30.0"

        //STUDENT ADVANCE TICKET TEST: LESS THAN TEN DAYS IN ADVANCE
        Ticket t4 = new StudentAdvanceTicket(1532, 3);
        System.out.println(t4);
        //should print "Number: 1532, Price: $20.0"

        //STUDENT ADVANCE TICKET TEST: GREATER THAN TEN DAYS IN ADVANCE
        Ticket t5 = new StudentAdvanceTicket(15324, 18);
        System.out.println(t5);
        //should print "Number: 15324, Price: $15.0"

    }
}

//Superclass for tickets, not supposed to be accessed
class Ticket {
    private int number; //instance variable for ticket card number

    //constructor to initialize number
    public Ticket(int number) {
        this.number = number;
    }

    //accessor method for number
    public int getNumber() {
        return number;
    }

    //mutator method for number
    public void setNumber(int number) {
        this.number = number;
    }
}

//extended class of Ticket for Walkup tickets
class WalkupTicket extends Ticket {

    //single variable constructor to set number
    public WalkupTicket(int number) {
        super(number); //uses constructor of Ticket superclass
    }

    //returns price of a Walkup ticket when called
    public double getPrice() {
        return 50;
    }

    //toString that returns the ticket information in format requested in problem
    public String toString() {
        return "Number: " + super.getNumber() + ", Price: $" + getPrice();
    }
}

//extended class of Ticket for Advance tickets
class AdvanceTicket extends Ticket {
    private int daysAdvance; /*instance variable to record the number of days in advance a ticket was purchased,
    so price can be determined  */

    //double variable constructor to set ticket number and days in advance the ticket was purchased
    public AdvanceTicket(int number, int daysAdvance) {
        super(number); //calls the Ticket Superclass number constructor
        this.daysAdvance = daysAdvance;
    }

    //returns thne price of an advance ticket depending on days before event the ticket was purchased
    public double getPrice() {
        if (daysAdvance >= 10) {
            return 30;
        } else {
            return 40;
        }
    }

    //accessor method to get num of days in advance the ticket was purchased
    public int getDaysAdvance() {
        return daysAdvance;
    }

    //mutator method to set num of days in advance the ticket was purchased if needed
    public void setDaysAdvance(int daysAdvance) {
        this.daysAdvance = daysAdvance;
    }

    //toString to print information of the ticket in accordance to problem format
    public String toString() {
        return "Number: " + super.getNumber() + ", Price: $" + getPrice();
        /*uses the Ticket superclass getNumber method, and the AdvanceTicket inClass getPrice method*/
    }
}

//extended class of Ticket for Advance tickets for students specifically
class StudentAdvanceTicket extends AdvanceTicket {

    //double variable constructor to set ticket number and days in advance a ticket was bought
    public StudentAdvanceTicket(int number, int daysAdvance) {
        super(number, daysAdvance); //uses AdvanceTicket superclass constructor
    }

    //returns price of StudentAdvanceTicket depending on days in advane ticket was bought
    public double getPrice() {
        if (super.getDaysAdvance() >= 10) {
            return 15;
        } else {
            return 20;
        }
    }

    //toString to return the ticket information, since it is student, also has (ID Required)
    public String toString() {
        return super.toString() + " (ID Required)"; //uses the toString of AdvanceTicket superclass
    }
}


