public class RocketShip {
	public static void main(String[] args){
		triangle();
		square();
		us();
		us();
		square();
		triangle();
	}
	public static void square(String[] args){
		System.out.println("----------");
		System.out.println("| United |");
		System.out.println("| States |");
		System.out.println("----------");
	}
	
	public static void us(String[] args){
		System.out.println("----------");
		System.out.println("|        |");
		System.out.println("|        |");
		System.out.println("----------");
	}
	
	public static void triangle(String[] args){
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= (3-i); i++) {
				System.out.print(" ");
			}
			System.out.println("/");
			for (int j = 0; j <= i; i++) {
				System.out.print(" ");
			}
			System.out.println("\\");
		}
	}
}