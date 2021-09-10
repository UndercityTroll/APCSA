public class RocketShipForLoopConstants {
    public static final int ROCKET_SECTIONS = 2;
    public static final int ROCKET_WIDTH = 14;
    public static final int CONE_WIDTH = ROCKET_WIDTH/2;
	public static void main(String[] args){
		triangle(CONE_WIDTH);
        for (int i = 1; i <= ROCKET_SECTIONS; i ++){
            square("      ","      ", ROCKET_WIDTH);
            square("United","States", ROCKET_WIDTH);
            square("United","States", ROCKET_WIDTH);
            square("      ","      ", ROCKET_WIDTH);
        }
		triangle(CONE_WIDTH);
	}
    public static void line(int w){
        System.out.print(" |");
		for (int i = 1; i <= w; i ++){
            System.out.print("-");
        }
        System.out.println("|");
    }
    public static void textLine(String l, int w){
        System.out.print(" |");
        for(int i = 1; i <= (w-l.length())/2; i++){
            System.out.print(" ");
        }
        System.out.print(l);
        for(int i = 1; i <= (w-l.length())/2; i++){
            System.out.print(" ");
        }
        System.out.println("|");
    }
	public static void square(String l1, String l2, int width){
        line(width);
		textLine(l1, width);
		textLine(l2, width);
		line(width);
	}
	
	public static void triangle(int length){
		for (int i = 0; i <= length-1; i++) {
			for (int j = 0; j <= (length-i); j++) {
				System.out.print(" ");
			}
			System.out.print("/");
			for (int k = 0; k < i*2; k++) {
				System.out.print(" ");
			}
			System.out.println("\\");
		}
	}
}