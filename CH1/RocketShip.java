public class RocketShip {
	public static void main(String[] args){
		triangle(4);
		square("      ","      ");
		square("United","States");
		square("United","States");
		square("      ","      ");
		triangle(4);
	}
	public static void square(String l1, String l2){
		System.out.println(" |--------|");
		System.out.println(" | "+l1+" |");
		System.out.println(" | "+l2+" |");
		System.out.println(" |--------|");
	}
	
	public static void triangle(int length){
		for (int i = 0; i <= length-1; i++) {
			for (int j = 0; j <= (length-i); j++) {
				System.out.print(" ");
			}
			System.out.print("/");
			for (int k = 0; k <= i*2; k++) {
				System.out.print(" ");
			}
			System.out.println("\\");
		}
	}
}