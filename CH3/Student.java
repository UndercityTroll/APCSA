public class Student{
    public static void main(String[] args){
        String studentName = "mike";
        int studentID = 69420;
        boolean studentIsSenior = true;
		studentInfo(studentName, studentID, studentIsSenior);
    }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  

    public static void studentInfo(String name, int id, boolean isSenior){
        System.out.println();
        System.out.println("name: "+name);
        System.out.println("Student ID: "+id);
        System.out.println("The Student is a Senior: "+isSenior);
    }

}