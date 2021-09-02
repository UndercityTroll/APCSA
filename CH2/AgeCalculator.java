public class AgeCalculator{
	public static void main(String[] args){
		
		// variables section
		int currentYear = 2021;
		int myYearBorn = 2003;
		int myPetYearBorn = 2008;
		int petAgeScalar = 7;
		
		// output section
		System.out.println("I am "+(currentYear-myYearBorn)+" years old!");
		System.out.println("My pet is "+(currentYear-myPetYearBorn)+" years old!");
		System.out.println("My pet is "+(currentYear-myPetYearBorn)*petAgeScalar+" years old in human years!");

		forLoop();
	}
	public static void forLoop(){
		for(int i = 1; i<=4; i++){
			System.out.println("2 times "+i+" = "+2*i);
		}

	}
}