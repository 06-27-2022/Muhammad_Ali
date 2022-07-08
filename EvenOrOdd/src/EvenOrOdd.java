
public class EvenOrOdd {
	public static void main(String[] args) {
		evenOrOdd(23);
		evenOrOdd(144);
		evenOrOdd(1);
	}
	
	static void evenOrOdd(int number){
		if(number % 2 == 0) 
			System.out.println("Even");
		else
			System.out.println("Odd");	
	}
}
