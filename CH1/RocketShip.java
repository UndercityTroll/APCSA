public class RocketShip {
	public static void main(String[] args){
		triangle();
		square();
		us();
		us();
		square();
		triangle();
	}
	public static void us(){
		System.out.println("----------");
		System.out.println("| United |");
		System.out.println("| States |");
		System.out.println("----------");
	}
	
	public static void square(){
		System.out.println("----------");
		System.out.println("|        |");
		System.out.println("|        |");
		System.out.println("----------");
	}
	
	public static void triangle(){
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= (2-i); j++) {
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