public class MathEquation{
    public static final double x1  = 1;
    public static final double x2  = 2;
    public static final double y1  = 4;
    public static final double y2  = 5;

    public static void main(String[] args){
		double m = slope(x1, x2, y1, y2);
        double d = distance(x1, x2, y1, y2);
        String Mess1 = "slope: ";
        String Mess2 = "Distance: ";
        print(Mess1, m);
        print(Mess2, d);
    }
    // ----------------------------------------- END MAIN METHOD ---------------------------------  

    public static double slope(double x1, double x2, double y1,double y2){
        return (y2-y1)/(x2-x1);
    }

    public static double distance(double x1, double x2, double y1,double y2){
        return Math.sqrt(Math.pow(y2-y1,2)+Math.pow(x2-x1,2));
    }
    public static void print(String Mess, double math){
        System.out.println(Mess+math);
    }
}