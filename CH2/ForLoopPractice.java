public class ForLoopPractice{
	public static void main(String[] args){
		
		// variables section
		p5();
		p6();
		p7();
		p8();
	}
	public static void p5(){
		System.out.println();
		for(int i=1;i<=4;i++){
			System.out.println("*****");
		}
	}
	public static void p6(){
		System.out.println();
		for(int i=1;i<=5;i++){
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void p7(){
		System.out.println();
		for(int i=1;i<=7;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public static void p8(){
		System.out.println();
		for(int i=1;i<=5;i++){
			for(int j=1;j<=(5-i);j++){
				System.out.print(" ");
			}
			System.out.println(i);
		}
	}
}